package org.example.threadCorredor;

import java.util.Random;

public class Corredor extends Thread {
    private String nombre;
    private int meta;

    public Corredor(String nombre) {

        this.nombre = nombre;
    }

    int contador = 0;
    public void run() {
        Random rand = new Random();
        while (this.contador < 100) {
            this.meta = rand.nextInt(10);
            System.out.println(this.nombre + " Ha avanzado " + this.meta + " metros. Lleva un total de " + this.contador + " metros.");
            this.contador += this.meta;
        }
        System.out.println(this.nombre + " ha llegado a la meta !!");

    }
}
