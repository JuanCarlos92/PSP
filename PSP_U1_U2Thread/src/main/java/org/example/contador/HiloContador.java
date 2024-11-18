package org.example.contador;

public class HiloContador extends Thread {
    private Contador contador;

    public HiloContador(Contador contador) {

        this.contador = contador;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}
