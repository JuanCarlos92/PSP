package org.juancarlos.micro_contactos_asincrono.service;

import org.juancarlos.micro_contactos_asincrono.dao.AgendaDao;
import org.juancarlos.micro_contactos_asincrono.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService{

    @Autowired
    private AgendaDao dao;

    @Override
    public boolean agregarContacto(Contacto contacto) {
        if (dao.existsById(contacto.getIdContacto()) || dao.findByEmail(contacto.getEmail()) != null) {
            return false;
        }
        dao.save(contacto);
        return true;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return dao.findAll();
    }

    @Override
    public boolean actualizarContacto(Contacto contacto) {
        if (dao.existsById(contacto.getIdContacto())) {
            dao.save(contacto);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarContacto(int id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Contacto buscarPorEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public boolean eliminarContactoPorEmail(String email) {
        if (dao.findByEmail(email) != null) {
            dao.deleteByEmail(email);
            return true;
        }
        return false;
    }
}
