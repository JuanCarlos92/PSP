package org.example;

import java.io.File;
import java.io.IOException;

public class Ejem4simplificado {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "DIR");
        pb.redirectInput(new File("entrada.txt"));
        pb.redirectOutput(new File("salida.txt"));
        pb.redirectError(new File("error.txt"));
        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
