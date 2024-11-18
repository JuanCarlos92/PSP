package org.example.threadCorredor;

public class Carrera {
    public static void main(String[] args) {
        Corredor c1 = new Corredor("Corredor1");
        Corredor c2 = new Corredor("Corredor2");
        Corredor c3 = new Corredor("Corredor3");
        c1.start();
        c2.start();
        c3.start();
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
