package com.juancarlos.microservicioModelCRUD.models;

// @JacksonXmlRootElement(localName = "Curso")
public class Curso {
    // @JacksonXmlProperty(localName = "id")
    private Long id;
    // @JacksonXmlProperty(localName = "nombre")
    private String nombre;
    // @JacksonXmlProperty(localName = "horario")
    private String horario;
    
    public Curso() {
    }

    public Curso(Long id, String nombre, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    

}
