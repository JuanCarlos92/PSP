/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

/**
 *
 * @author JuanCarlos
 */
public class Revista extends Libro{

    //Atributo de la clase Revista (Private ya que no ereda a ninguna otra clase)
    private int numEdicion;

    //Constructo vacio y con parámetros
    public Revista() {

    }

    public Revista(int numPaginas, String autor, String titulo, int numEdicion) {
        super(numPaginas, autor, titulo);
        this.numEdicion = numEdicion;
    }

    //Metodo de la revista sobrecargado añadiendole el numero de ediccion.
    @Override
    public void detalle() {
        System.out.println("Titulo: " + this.titulo
                + ", Autor: " + this.autor + ", Numero de paginas: " + this.numPaginas
                + ", numero de ediccion: " + this.numEdicion);
    }
}
