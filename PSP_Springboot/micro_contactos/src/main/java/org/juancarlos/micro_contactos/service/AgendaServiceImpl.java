package org.juancarlos.micro_contactos.service;

import org.juancarlos.micro_contactos.dao.AgendaDao;
import org.juancarlos.micro_contactos.model.Contacto;

import java.util.List;

public class AgendaServiceImpl implements AgendaService{

    private final AgendaDao dao;

    // Constructor para inyectar la dependencia
    //@Autowired
    public AgendaServiceImpl(AgendaDao dao) {   //Para evitar el uso de @Autowired y hacer el objeto dao inmutable
        this.dao = dao;
    }

    @Override
    public boolean agregarContacto(Contacto contacto) {
        //a�ade el contacto si no existe
        if(dao.recuperarContacto(contacto.getIdContacto())==null) {
            dao.agregarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return dao.devolverContactos();
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        //elimina el contacto si existe
        if(dao.recuperarContacto(contacto.getIdContacto())!=null) {
            dao.actualizarContacto(contacto);
        }
    }

    @Override
    public boolean eliminarContacto(int idcontacto) {
        if(dao.recuperarContacto(idcontacto)!=null) {
            dao.eliminarContacto(idcontacto);
            return true;
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(int idcontacto) {
        return dao.recuperarContacto(idcontacto);
    }
}
