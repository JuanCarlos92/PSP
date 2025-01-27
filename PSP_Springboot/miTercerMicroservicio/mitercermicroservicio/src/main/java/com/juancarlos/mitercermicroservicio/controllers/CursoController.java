package com.juancarlos.mitercercroservicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.mitercercroservicio.models.Curso;
import com.juancarlos.mitercercroservicio.services.CursoService;


@RestController
@RequestMapping
public class CursoController {

    @Autowired 
    private CursoService service;

    @GetMapping (value="cursos", produces=MediaType.APPLICATION_XML_VALUE)
    public List<Curso> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Curso show(@PathVariable Long id) {
        return service.findById(id);
    }
}