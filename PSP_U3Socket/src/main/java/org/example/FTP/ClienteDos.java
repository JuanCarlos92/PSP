package org.example.FTP;

import org.apache.commons.net.ftp.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ClienteDos {

    public static void cliente() throws IOException {

        FTPClient clienteDos = new FTPClient();
        String servFTP = "ftp.rediris.es";
        System.out.println("Conectar a: " + servFTP);

        String user = "anonymous";
        String pass = "anonymous";
        clienteDos.connect(servFTP);
        clienteDos.enterLocalPassiveMode(); // Entrar en modo pasivo

        boolean login = clienteDos.login(user, pass);
        if (login) {
            System.out.println("Login Correcto.");
        } else {
            System.out.println("Login Incorrecto.");
            clienteDos.disconnect();
            System.exit(1);
        }

        System.out.println("Directorio actual: " + clienteDos.printWorkingDirectory());

        // Listar archivos en el directorio raíz
        listarArchivos(clienteDos);
        System.out.println("\n-------------------------------------------------------------------------------------------\n");

        // Cambiar al directorio 'sites'
        String directorio = "/Desktop";
        if (clienteDos.changeWorkingDirectory(directorio)) {
            System.out.println(">> Cambiado al directorio: " + directorio);
            listarArchivos(clienteDos); // Listar archivos en el directorio 'sites'
        } else {
            System.out.println("No se pudo cambiar al directorio: " + directorio);
        }

        // Descargar un archivo específico
        System.out.println("\n------------------------------------------------------------------\n");
        String archivoRemoto = "extrafiles"; // Cambia esto por el archivo que quieres descargar
        String archivoLocal = "/home/ivandavid/Imágenes/extrafiles.txt"; // Ruta local para guardar el archivo

        try (OutputStream outputStream = new FileOutputStream(archivoLocal)) {
            boolean exito = clienteDos.retrieveFile(archivoRemoto, outputStream);
            if (exito) {
                System.out.println("Archivo descargado correctamente: " + archivoLocal);
            } else {
                System.out.println("Error al descargar el archivo: " + archivoRemoto);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------------------------\n");

        boolean logout = clienteDos.logout();
        if (logout) {
            System.out.println("Logout del servidor FTP correcto.");
        } else {
            System.out.println("Logout del servidor FTP incorrecto.");
        }

        // Respuesta del servidor FTP.
        System.out.println(clienteDos.getReplyString());
        // Obtener código de respuesta
        int respuesta = clienteDos.getReplyCode();
        System.out.println("Respuesta: " + respuesta);

        // Comprobar la respuesta
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteDos.disconnect();
            System.out.println("Conexion rechazada: " + respuesta);
            System.exit(0);
        }

        // Desconectar del servidor FTP
        clienteDos.disconnect();
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

