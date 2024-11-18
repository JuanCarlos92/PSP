package org.example;

import java.util.concurrent.Semaphore;

public class CineSimulacion {
    public static void main(String[] args) {
        Semaphore asientos = new Semaphore(3);  // Solo 3 asientos disponibles

        // Simulamos 6 personas que intentan entrar al cine
        for (int i = 1; i <= 6; i++) {
            String persona = "Persona " + i;
            new Thread(new Cine(asientos, persona)).start();
        }
    }
}
