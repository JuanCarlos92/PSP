package com.contactos.pruebasmicroservicio_contactos_securizado.service;

import com.contactos.pruebasmicroservicio_contactos_securizado.model.Contacto;

import java.util.List;

public interface AgendaService {
    boolean agregarContacto(Contacto contacto);
    List<Contacto> recuperarContactos();
    void actualizarContacto(Contacto contacto);
    boolean eliminarContacto(int idcontacto);
    Contacto buscarContacto(int idcontacto);
}
