package org.example;

import java.util.concurrent.Semaphore;

class Cine implements Runnable {
    private Semaphore asientos;
    private String persona;

    public Cine(Semaphore asientos, String persona) {
        this.asientos = asientos;
        this.persona = persona;
    }

    @Override
    public void run() {
        try {
            System.out.println(persona + " está esperando para entrar al cine.");
            asientos.acquire();  // Adquiere un asiento, si no hay espera hasta que uno se libere
            System.out.println(persona + " ha entrado al cine y está viendo la película.");
            Thread.sleep(3000);  // Simula el tiempo que la persona pasa viendo la película
            System.out.println(persona + " ha terminado de ver la película y ha salido del cine.");
            asientos.release();  // Libera el asiento para que otra persona pueda entrar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
