package org.juancarlos.micro_contactos_asincrono.controller;

import org.juancarlos.micro_contactos_asincrono.model.Contacto;
import org.juancarlos.micro_contactos_asincrono.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactosController {

    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<Contacto>> recuperarContactos() {
        // Llamada al servicio para obtener la lista de contactos
        List<Contacto> contactos = service.recuperarContactos();
        // Creación de un objeto HttpHeaders para añadir encabezados personalizados
        HttpHeaders headers = new HttpHeaders();
        // Añadir un encabezado con el número total de contactos
        headers.add("total", String.valueOf(contactos.size()));
        System.out.println(headers.get("total"));

        try{
            System.out.println("Esperando...");
            Thread.sleep(5000);
            System.out.println("Finalizado.");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // Devolver una respuesta HTTP con la lista de contactos, los encabezados y un estado HTTP 200 (OK)
        return new ResponseEntity<>(contactos, headers, HttpStatus.OK);
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
