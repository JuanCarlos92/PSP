package org.example.microservicio_clientewebclient.controller;

import org.example.microservicio_clientewebclient.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClienteContactoController {
    String urlBase="http://localhost:8080";

    @Autowired
    private WebClient webClient;

    @GetMapping("/personas/{nombre}/{email}/{edad}")
    public List<Persona> altaNueva(@PathVariable("nombre") String nombre,
                                   @PathVariable("email") String email,
                                   @PathVariable("edad") int edad) {
        Persona persona = new Persona(nombre,email,edad);

        webClient.post()
                .uri(urlBase+"/contactos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(persona)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Persona[] personas = webClient.get()
                .uri(urlBase+"/contactos")
                .retrieve()
                .bodyToMono(Persona[].class)
                .block();

        return List.of(personas);
    }

//    @GetMapping("/personas/{edad1}/{edad2}")
//    public List<Persona> buscarEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {
//
//
//        List<Persona> resultado = new ArrayList<>();
//        for (Persona persona : personas) {
//            if (persona.getEdad() >= edad1 && persona.getEdad() <= edad2) {
//                resultado.add(persona);
//            }
//        }
//        return resultado;
//    }
}



