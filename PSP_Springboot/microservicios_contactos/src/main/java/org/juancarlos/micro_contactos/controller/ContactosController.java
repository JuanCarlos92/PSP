package org.juancarlos.micro_contactos.controller;

import org.juancarlos.micro_contactos.model.Contacto;
import org.juancarlos.micro_contactos.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactosController {

    @Autowired
    private AgendaService service;

    @GetMapping()
    public List<Contacto> recuperarContactos() {
        return service.recuperarContactos();
    }

    @GetMapping("/{id}")
    public Contacto recuperarContactosId(@PathVariable("id") int id) {
        return service.buscarContacto(id);
    }
    @GetMapping("/email/{email}")
    public Contacto recuperarContactosEmail(@PathVariable("email") String email) {
        return service.buscarPorEmail(email);
    }

    @PostMapping
    public String guardarContacto(@RequestBody Contacto contacto) {
        boolean agregado = service.agregarContacto(contacto);
        return agregado ? "Contacto agregado correctamente" : "El contacto ya existe";
    }

    @PutMapping
    public String actualizarContacto(@RequestBody Contacto contacto) {
        boolean actualizado = service.actualizarContacto(contacto);
        return actualizado ? "Contacto actualizado correctamente" : "El contacto no existe";
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable int id) {
        boolean eliminado = service.eliminarContacto(id);
        return eliminado ? "Contacto eliminado correctamente" : "El contacto no existe";
    }

    @DeleteMapping("/email/{email}")
    public String eliminarPorEmail(@PathVariable String email) {
        boolean eliminado = service.eliminarContactoPorEmail(email);
        return eliminado ? "Contacto eliminado correctamente" : "El contacto no existe";
    }

}
