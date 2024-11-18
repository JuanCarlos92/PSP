package org.example.contador;

public class Contador {
    private int cuenta;

    public synchronized void incrementar() {
        this.cuenta++;

    }

    public int getCuenta() {

        return cuenta;
    }

}
