package org.example.microservicio_clientewebclient.controller;

import org.example.microservicio_clientewebclient.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ClienteContactoController {
    @Value("${app.user}")
    String user;
    @Value("${app.pass}")
    String pass;
    String urlBase = "http://localhost:8080/contactos";

    @Autowired
    private WebClient webClient;

    @GetMapping("/personas/{nombre}/{email}/{edad}")
    public List<Persona> altaNueva(@PathVariable("nombre") String nombre,
                                   @PathVariable("email") String email,
                                   @PathVariable("edad") int edad) {
        Persona persona = new Persona(nombre, email, edad);

        webClient.post()
                .uri(urlBase)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(persona)
                //.header("Authorization", "Basic " + getBase64(user,pass))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        // Llamada para obtener todas las personas existentes
        Persona[] personas = webClient.get()
                .uri(urlBase)
                //.header("Authorization", "Basic " + getBase64(user,pass))
                .retrieve()
                .bodyToMono(Persona[].class)
                .block();

        return (personas != null) ? Arrays.asList(personas) : Collections.emptyList();
    }

    @GetMapping("/personas/{edad1}/{edad2}")
    public List<Persona> buscarEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {

        // Recupera todas las personas del servicio remoto
        Persona[] personas = webClient.get()
                .uri(urlBase)
                .retrieve()
                .bodyToMono(Persona[].class)
                .block();

        // Filtra las personas por el rango de edades especificado
        return Arrays.stream(personas)
                .filter(p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
                .collect(Collectors.toList());
    }

    private String getBase64(String user, String pass) {
        String cad = user + ":" + pass;
        return Base64.getEncoder().encodeToString(cad.getBytes());
    }
}



