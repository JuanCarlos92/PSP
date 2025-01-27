package com.juancarlos.misegundomicroservicio.repositories;

import java.util.List;

import com.juancarlos.misegundomicroservicio.models.Curso;

public interface CursoRepository {

    List<Curso>  findAll();

    Curso findById(Long id);

    Curso deleteById(Long id);

    Curso save(Curso curso);
    
}
