package com.juancarlos.microservicioModelCRUD.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.juancarlos.microservicioModelCRUD.models.Curso;
import com.juancarlos.microservicioModelCRUD.services.CursoService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class CursoController {

    @Autowired
    private CursoService service;

    // @GetMapping(value = "cursos", produces = MediaType.APPLICATION_XML_VALUE)
    // public List<Curso> list() {
    // return service.findAll();
    // }

    // @GetMapping(value = "cursos/{id}", produces =
    // MediaType.APPLICATION_XML_VALUE)
    // public Curso show(@PathVariable Long id) {
    // return service.findById(id);
    // }

    @GetMapping
    public List<Curso> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Curso show(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public Curso create(@RequestBody Curso curso) {
        return service.save(curso);
    }

    @PutMapping("/update/{id}")
    public Curso update(@PathVariable Long id, @RequestBody Curso curso) {
        Curso existeCurso = service.findById(id);
        if (existeCurso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con ID: " + id);
        }

        existeCurso.setNombre(curso.getNombre());
        existeCurso.setHorario(curso.getHorario());
        return existeCurso;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Curso existeCurso = service.findById(id);
        if (existeCurso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con ID: " + id);
        }

        service.deleteById(id);
        return "Curso eliminado con ID: " + id;
    }
}