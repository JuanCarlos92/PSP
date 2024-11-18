package org.example;

import java.io.File;
import java.io.IOException;

public class Ejem4_Redireccionar {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "findstr", "ejemplito");
            pb.redirectInput(new File("entrada.txt"));
            pb.redirectOutput(new File("salida.txt"));
            pb.redirectError(new File("error.txt"));
            Process p = pb.start();
            int exitVal = p.exitValue();
            System.out.println("El proceso termino con valor de salida: " + exitVal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}