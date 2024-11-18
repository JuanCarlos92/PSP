package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutarDir {
    public static void main(String[] args) throws IOException {
        // Ejecutamos el comando dir
        Process pb = new ProcessBuilder("cmd", "/c", "dir").start();
        // En linux, el equivalente sería el comando ls
        //Process pb = new ProcessBuilder("bash", "-c", "ls").start();

        // Capturamos la salida del proceso
        BufferedReader reader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
        String linea;

        // Imprimimos cada línea de la salida
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
    }
}
