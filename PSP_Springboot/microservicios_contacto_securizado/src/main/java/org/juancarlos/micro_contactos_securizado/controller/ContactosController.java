package org.juancarlos.micro_contactos_securizado.controller;

import org.juancarlos.micro_contactos_securizado.model.Contacto;
import org.juancarlos.micro_contactos_securizado.service.AgendaService;
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
        // Devolver una respuesta HTTP con la lista de contactos, los encabezados y un estado HTTP 200 (OK)
        return new ResponseEntity<>(contactos, headers, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Contacto> recuperarContactosId(@PathVariable("id") int id) {
        // Llamada al servicio para buscar un contacto por su ID
        // Devolver una respuesta HTTP con el contacto y un estado HTTP 200 (OK)
        return new ResponseEntity<>(service.buscarContacto(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Contacto> recuperarContactosEmail(@PathVariable("email") String email) {
        // Llamada al servicio para buscar un contacto por su email
        // Devolver una respuesta HTTP con el contacto y un estado HTTP 200 (OK)
        return new ResponseEntity<>(service.buscarPorEmail(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> guardarContacto(@RequestBody Contacto contacto) {
        // Llamada al servicio para agregar un nuevo contacto
        boolean agregado = service.agregarContacto(contacto);
        if (agregado) {
            // Devolver una respuesta HTTP con un estado HTTP 200 (OK) si el contacto se agrega correctamente
            return new ResponseEntity<>("Contacto agregado", HttpStatus.CREATED);
        }else{
            // Devolver una respuesta HTTP con un estado HTTP 409 (Conflict) si hay un problema al agregar el contacto
            return new ResponseEntity<>("Contacto no agregado", HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<String> actualizarContacto(@RequestBody Contacto contacto) {
        // Llamada al servicio para actualizar contacto
        boolean actualizado = service.actualizarContacto(contacto);
        if (actualizado) {
            // Devolver una respuesta HTTP con un estado HTTP 200 (OK) si el contacto se agrega correctamente
            return new ResponseEntity<>("Contacto actualizado", HttpStatus.OK);
        }else{
            // Devolver una respuesta HTTP con un estado HTTP 409 (Conflict) si hay un problema al agregar el contacto
            return new ResponseEntity<>("Contacto no actualizado", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable int id) {
        // Llamada al servicio para eliminar contacto
        boolean eliminado = service.eliminarContacto(id);
        if (eliminado) {
            // Devolver una respuesta HTTP con un estado HTTP 200 (OK) si el contacto se agrega correctamente
            return new ResponseEntity<>("Contacto eliminado", HttpStatus.OK);
        }else{
            // Devolver una respuesta HTTP con un estado HTTP 409 (Conflict) si hay un problema al agregar el contacto
            return new ResponseEntity<>("Contacto no eliminado", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> eliminarPorEmail(@PathVariable String email) {
        // Llamada al servicio para eliminar contacto por el email
        boolean eliminado = service.eliminarContactoPorEmail(email);
        if (eliminado) {
            // Devolver una respuesta HTTP con un estado HTTP 200 (OK) si el contacto se agrega correctamente
            return new ResponseEntity<>("Contacto eliminado", HttpStatus.OK);
        }else{
            // Devolver una respuesta HTTP con un estado HTTP 409 (Conflict) si hay un problema al agregar el contacto
            return new ResponseEntity<>("Contacto no eliminado", HttpStatus.CONFLICT);
        }
    }
}
