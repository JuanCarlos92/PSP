/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

/**
 *
 * @author JuanCarlos
 */
public class Libro {

    //Atributos Libro (Protected para que herede a la clase revista)
    protected String titulo;
    protected String autor;
    protected int numPaginas;

    //Contructor vacío y con parámetros
    public Libro() {

    }

    public Libro(int numPaginas, String autor, String titulo) {
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    //Metodo void para devolver el System.ou.println cuando es llamado
    public void detalle() {
        System.out.println("Titulo: " + this.titulo
                + ", Autor: " + this.autor + ", Numero de paginas: " + this.numPaginas);
    }
}
