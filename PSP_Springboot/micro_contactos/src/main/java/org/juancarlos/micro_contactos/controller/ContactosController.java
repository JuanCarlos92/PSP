package org.juancarlos.micro_contactos.controller;

import org.juancarlos.micro_contactos.model.Contacto;
import org.juancarlos.micro_contactos.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*") //permite recibir peticiones desde cualquier origen
@RestController
public class ContactosController {

    @Autowired
    private final AgendaService service;

    public ContactosController(AgendaService service) {

        this.service = service;
    }

    @GetMapping(value="contactos")
    public List<Contacto> recuperarContactos() {

        return service.recuperarContactos();
    }

    @GetMapping(value="contactos/{id}")
    public Contacto recuperarContactos(@PathVariable("id") int id) {

        return service.buscarContacto(id);
    }

    @PostMapping(value="contactos")
    public String guardarContacto(@RequestBody Contacto contacto) {
        return String.valueOf(service.agregarContacto(contacto));
    }

    @PutMapping(value="contactos")
    public void actualizarContacto(@RequestBody Contacto contacto) {

        service.actualizarContacto(contacto);
    }

    @DeleteMapping(value="contactos/{id}")
    public void eliminarPorId(@PathVariable("id") int idContacto) {

        service.eliminarContacto(idContacto);
    }


}
