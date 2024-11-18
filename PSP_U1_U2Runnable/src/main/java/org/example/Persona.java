package org.example;

public class Persona {
    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void ticar_entrada() {
        System.out.println(nombre + " ha realizado el check IN");
    }
    public void ticar_salida() {
        System.out.println(nombre + " ha realizado el check OUT");
    }
}

