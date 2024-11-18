package org.example;

import java.util.concurrent.Semaphore;

public class Impresoras implements Runnable {
    private Semaphore impresoras;
    private String empleado;

    public Impresoras (int cantidadImpresora){
    this.impresoras = new Semaphore(cantidadImpresora);


    }
}
