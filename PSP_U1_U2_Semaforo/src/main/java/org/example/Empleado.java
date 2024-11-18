package org.example;


public class Empleado extends Thread {
    private Impresoras impresoras;
    private String empleado;
    
    public Empleado(Impresoras impresora, String nombreEmpleado) {
        this.impresoras = impresoras;
        this.empleado = empleado;
    }

    public void realizarImpresion() {
        new Thread(new Impresoras(2)).start();
    }
}