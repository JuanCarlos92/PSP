package com.juancarlos.mitercercroservicio.repositories;

import java.util.List;

import com.juancarlos.mitercercroservicio.models.Curso;

public interface CursoRepository {

    List<Curso>  findAll();

    Curso findById(Long id);
    
}
