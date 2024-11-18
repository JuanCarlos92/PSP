package org.example;

public class MiRunnable implements Runnable {

    public void run() {
        // Código que se ejecutará en el hilo
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo en ejecución: " + i);
        }
    }

}
