package org.example.contador;

public class SincronizacionHilos {
    public static void main(String[] args) {
        Contador contador = new Contador();

        HiloContador hilo1 = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);
        HiloContador hilo3 = new HiloContador(contador);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            System.out.println("Valor final del contador: " + contador.getCuenta());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
