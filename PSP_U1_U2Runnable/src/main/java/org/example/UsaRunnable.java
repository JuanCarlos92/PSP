package org.example;

public class UsaRunnable {
    public static void main(String[] args) {
        MiRunnable primerRunnable = new MiRunnable();

        Thread hilo = new Thread(primerRunnable);  // Creación del hilo pasando la instancia MiRunnable
        hilo.start();  // Inicia el hilo
    }
}
