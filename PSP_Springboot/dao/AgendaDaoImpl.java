package org.juancarlos.micro_contactos.dao;


import org.juancarlos.micro_contactos.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgendaDaoImpl implements AgendaDao2 {

    @Autowired
    AgendaDao agenda;

    @Override
    public void agregarContacto(Contacto contacto) {
        agenda.save(contacto);
    }

    @Override
    public Contacto recuperarContacto(String email) {
        return agenda.findByEmail(email);
    }

    @Override
    public void eliminarContacto(String email) {
        agenda.deleteByEmail(email);
    }

    @Override
    public List<Contacto> devolverContactos() {
        return agenda.findAll();
    }

    @Override
    public void eliminarContacto(int id) {
        agenda.deleteById(id);
    }

    @Override
    public Contacto recuperarContacto(int id) {
        return agenda.findById(id).orElse(null);
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        agenda.save(contacto);
    }
}
