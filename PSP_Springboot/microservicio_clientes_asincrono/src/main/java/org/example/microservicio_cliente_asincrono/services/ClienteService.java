package org.example.microservicio_cliente_asincrono.services;

import org.example.microservicio_cliente_asincrono.model.Persona;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ClienteService {
    CompletableFuture<List<Persona>> llamadaServicio(Persona persona);

}
