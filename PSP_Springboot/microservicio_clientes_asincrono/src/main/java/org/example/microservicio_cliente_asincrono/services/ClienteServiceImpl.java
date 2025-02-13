package org.example.microservicio_cliente_asincrono.services;
import org.example.microservicio_cliente_asincrono.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    RestTemplate restTemplate;

    public String url = "http://localhost:8080";

    @Override
    @Async
    public CompletableFuture<List<Persona>> llamadaServicio(Persona persona) {
        restTemplate.postForLocation(url + "/contactos/contacto", persona);
        Persona[] personas = restTemplate.getForObject(url + "/contactos", Persona[].class);
        return CompletableFuture.completedFuture(Arrays.asList(personas));
    }
}
