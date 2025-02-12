package org.juancarlos.micro_contactos_asincrono.service;

import org.juancarlos.micro_contactos_asincrono.model.Contacto;

import java.util.List;

public interface AgendaService {
    boolean agregarContacto(Contacto contacto);
    List<Contacto> recuperarContactos();
    boolean actualizarContacto(Contacto contacto);
    boolean eliminarContacto(int id);
    Contacto buscarContacto(int id);
    Contacto buscarPorEmail(String email);
    boolean eliminarContactoPorEmail(String email);
}
