package com.juancarlos.microservicioModelCRUD.repositories;

import java.util.List;

import com.juancarlos.microservicioModelCRUD.models.Curso;

public interface CursoRepository {

    List<Curso>  findAll();

    Curso findById(Long id);

    Curso deleteById(Long id);

    Curso save(Curso curso);
    
}
