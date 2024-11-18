package org.example;

public class Empresa {
    public static void main(String[] args) throws InterruptedException {
        // Creamos los empleados
        Empleado empleado1 = new Empleado("Juan");
        Empleado empleado2 = new Empleado("Ana");

        Thread hilo1 = new Thread(empleado1);
        Thread hilo2 = new Thread(empleado2);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();
        System.out.println("Todos los empleados han terminado su trabajo.");
    }
}

