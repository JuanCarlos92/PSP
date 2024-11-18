/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author JuanCarlos
 */
public class Ejem3_Capturarproceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //ejecutar comando dir
        Process pb = new ProcessBuilder("cmd", "/c", "dir").start();

        //Capturar la salida del proceso
        BufferedReader reader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
        String linea;

        //Imprimir cada linea de la salida
        while ((linea = reader.readLine()) != null) {

            System.out.println(linea);
        }

    }
}
