package org.example.FTP;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FTPApp {
    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftpClient;

    // Constructor para inicializar la conexión
    public FTPApp(String server, int port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
        this.ftpClient = new FTPClient();
    }

    // Conectar al servidor
    public void connectAndLogin() throws IOException {
        ftpClient.connect(server, port);
        int replyCode = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(replyCode)) {
            throw new IOException("Error al conectar al servidor FTP. Código de respuesta: " + replyCode);
        }
        if (!ftpClient.login(user, password)) {
            throw new IOException("Error al iniciar sesión con las credenciales proporcionadas.");
        }
        ftpClient.enterLocalPassiveMode(); // Modo pasivo recomendado para evitar problemas de firewall
        System.out.println("Conexión exitosa a " + server);
    }

    // Cerrar conexión
    public void disconnect() throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.logout();
            ftpClient.disconnect();
            System.out.println("Conexión cerrada.");
        }
    }

    // Subir archivo al servidor
    public void uploadFile(String localFilePath, String remoteFilePath) throws IOException {
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Usar modo binario para archivos
        try (InputStream inputStream = new FileInputStream(localFilePath)) {
            boolean success = ftpClient.storeFile(remoteFilePath, inputStream);
            if (success) {
                System.out.println("Archivo subido correctamente: " + remoteFilePath);
            } else {
                System.out.println("Error al subir el archivo.");
            }
        }
    }

    // Descargar archivo del servidor
    public void downloadFile(String remoteFilePath, String localFilePath) throws IOException {
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Usar modo binario para archivos
        try (OutputStream outputStream = new FileOutputStream(localFilePath)) {
            boolean success = ftpClient.retrieveFile(remoteFilePath, outputStream);
            if (success) {
                System.out.println("Archivo descargado correctamente: " + localFilePath);
            } else {
                System.out.println("Error al descargar el archivo.");
            }
        }
    }

    // Mostrar archivos en el directorio remoto
    public void listRemoteFiles(String remotePath) throws IOException {
        FTPFile[] files = ftpClient.listFiles(remotePath);
        for (FTPFile file : files) {
            System.out.println((file.isDirectory() ? "[DIR] " : "[FILE] ") + file.getName());
        }
    }

    public static void main(String[] args) {
        String server = "localhost"; // Cambia esto por la IP o dominio del servidor FTP
        int port = 21; // Puerto FTP por defecto
        String user = "alumnodam"; // Usuario configurado en FileZilla
        String password = "psp"; // Contraseña configurada en FileZilla

        FTPApp ftpApp = new FTPApp(server, port, user, password);

        try {
            // Conectar y autenticar
            ftpApp.connectAndLogin();

            // Listar archivos del directorio remoto
            ftpApp.listRemoteFiles("/");

            // Subir un archivo al servidor
            ftpApp.uploadFile("C:/path/to/local/file.txt", "/remote/file.txt");

            // Descargar un archivo del servidor
            ftpApp.downloadFile("/remote/file.txt", "C:/path/to/downloaded/file.txt");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpApp.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

