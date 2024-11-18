package org.example;

import java.io.File;
import java.io.IOException;

public class RedireccionarEntradaSalida {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "findstr", "ejemplito");
            pb.redirectInput(new File("input.txt"));
            pb.redirectOutput(new File("output.txt"));
            pb.redirectError(new File("error.txt"));
            Process p = pb.start();

            // Esperar a que el proceso termine
            int exitVal = p.waitFor();
            System.out.println("El proceso terminó con valor de salida: " + exitVal);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

