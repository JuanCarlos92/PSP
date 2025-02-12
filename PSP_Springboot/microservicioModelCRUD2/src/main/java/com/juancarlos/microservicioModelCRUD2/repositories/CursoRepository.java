package com.juancarlos.microservicioModelCRUD2.repositories;

import java.util.List;

import com.juancarlos.microservicioModelCRUD2.models.Curso;

public interface CursoRepository {

    List<Curso>  findAll();

    Curso findById(Long id);
    
}
