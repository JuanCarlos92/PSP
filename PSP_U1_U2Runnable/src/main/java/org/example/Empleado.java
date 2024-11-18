package org.example;

public class Empleado extends Persona implements Runnable{
    public Empleado(String nombre) {
        super(nombre);
    }
    public void run() {

        ticar_entrada();

        System.out.println(nombre + " está trabajando...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nombre + " ha terminado su tarea.");

        ticar_salida();
    }
}


