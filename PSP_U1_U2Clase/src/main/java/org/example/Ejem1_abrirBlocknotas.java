package org.example;

import java.io.IOException;

//Abrir bloc de enotas
public class Ejem1_abrirBlocknotas {

    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
