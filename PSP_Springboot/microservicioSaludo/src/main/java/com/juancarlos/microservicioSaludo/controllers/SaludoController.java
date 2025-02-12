package com.juancarlos.microservicioSaludo.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping(value = "saludo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo() {
        return "Hola Mundo, este es mi primer microservicio";
    }

    @GetMapping(value = "saludopersonal", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo(@RequestParam ("name")String nombre, @RequestParam ("edad")int edad) {
        return "Bienvenido " + nombre + " tienes " + edad + " años";
    }
    
}
