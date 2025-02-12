package org.juancarlos.micro_contactos_securizado.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontacto", columnDefinition = "int UNSIGNED not null")
    private int idContacto;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "edad", columnDefinition = "int UNSIGNED not null")
    private int edad;


    public int getIdContacto() {

        return idContacto;
    }

    public void setIdContacto(int id) {

        this.idContacto = id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public int getEdad() {

        return edad;
    }

    public void setEdad(int edad) {

        this.edad = edad;
    }


}