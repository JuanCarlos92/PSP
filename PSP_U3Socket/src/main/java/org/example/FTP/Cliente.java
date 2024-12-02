package org.example.FTP;

import org.apache.commons.net.ftp.*;

import java.io.IOException;

public class Cliente {

    public static void cliente() throws IOException {

        FTPClient cliente = new FTPClient();
        String servFTP = "192.168.12.102";
        System.out.println("Conectar a: " + servFTP);

        String user = "pruebaftp";
        String pass = "pruebaftp";
        cliente.connect(servFTP);
        cliente.enterLocalPassiveMode(); //Tenemos que entrar en modo pasivo

        boolean login = cliente.login(user, pass);
        if (login) {
            System.out.println("Login Correctisimo ...");
        } else {
            System.out.println("Login Incorrectisimo ...");
            cliente.disconnect();
            System.exit(1);
        }

        System.out.println("Directorio actual: " + cliente.printWorkingDirectory());


        FTPFile[] files = cliente.listFiles();
        System.out.println("Ficheros en el directorio actual: " + files.length);

        //ARRAY PARA VISUALIZAR EL TIPO DE FICHERO
        String[] tipos = {"Fichero", "Directorio", "Enlace simb."};

        for (FTPFile file : files) {
            String tipo = (file.isFile()) ? tipos[0] : (file.isDirectory()) ? tipos[1] : tipos[2];
            System.out.printf("> Nombre: %s >> Tipo: %s >> Tamaño: %d bytes%n", file.getName(), tipo, file.getSize());
        }

//        for (int i = 0; i< files.length; i++){
//            files[i].getName();
//        }

        boolean logout = cliente.logout();
        if (logout) {
            System.out.println("Logout del servidor FTP correcto.");
        } else {
            System.out.println("Logout del servidor FTP incorrecto.");
        }

        //Respuesta del servidor FTP.
        System.out.println(cliente.getReplyString());
        // Obtener código de respuesta
        int respuesta = cliente.getReplyCode();
        System.out.println("Respuesta: " + respuesta);

        // Comprobar la respuesta
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            cliente.disconnect();
            System.out.println("Conexion rechazada: " + respuesta);
            System.exit(0);
        }

        // Desconectar del servidor FTP
        cliente.disconnect();
        System.out.println("Fin.");
    }
}



