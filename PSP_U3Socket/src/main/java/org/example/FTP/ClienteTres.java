package org.example.FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ClienteTres {
    public static void cliente() throws IOException {

        FTPClient clienteTres = new FTPClient();
        String servFTP = "192.168.12.102";
        System.out.println("Conectar a: " + servFTP);

        String user = "pruebaftp";
        String pass = "pruebaftp";
        clienteTres.connect(servFTP);
        clienteTres.enterLocalPassiveMode(); // Entrar en modo pasivo

        boolean login = clienteTres.login(user, pass);
        if (login) {
            System.out.println("Login Correcto.");
        } else {
            System.out.println("Login Incorrecto.");
            clienteTres.disconnect();
            System.exit(1);
        }

        System.out.println("Directorio actual: " + clienteTres.printWorkingDirectory());

        // Listar archivos en el directorio raíz
        listarArchivos(clienteTres);

        // Cambiar al directorio
        String directorio = "Escritorio/RECREO LARGO";
        if (clienteTres.changeWorkingDirectory(directorio)) {
            System.out.println(">> Cambiado al directorio: " + directorio);
            listarArchivos(clienteTres); // Listar archivos en el directorio
        } else {
            System.out.println("No se pudo cambiar al directorio: " + directorio);
        }

        String archivoRemoto = "3";
        String archivoLocal = "C:\\Users\\juanc\\Documents";

        try (OutputStream outputStream = new FileOutputStream(archivoLocal)) {
            boolean exito = clienteTres.retrieveFile(archivoRemoto, outputStream);
            if (exito) {
                System.out.println("Descargado correctamente: " + archivoLocal);
            } else {
                System.out.println("Error al descargar: " + archivoRemoto);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }


        boolean logout = clienteTres.logout();
        if (logout) {
            System.out.println("Logout del servidor FTP correcto.");
        } else {
            System.out.println("Logout del servidor FTP incorrecto.");
        }


        clienteTres.disconnect();
        System.out.println("Fin.");
    }

    private static void listarArchivos(FTPClient cliente) throws IOException {
        FTPFile[] files = cliente.listFiles();
        System.out.println(">> Ficheros en el directorio actual: " + files.length);

        String[] tipos = {"Archivo", "Directorio", "Enlace simbólico"};
        for (FTPFile file : files) {
            String tipo = (file.isFile()) ? tipos[0] :
                    (file.isDirectory()) ? tipos[1] :
                            tipos[2];
            System.out.printf("Nombre: %s, Tipo: %s, Tamaño: %d bytes%n",
                    file.getName(), tipo, file.getSize());
        }
    }
}

