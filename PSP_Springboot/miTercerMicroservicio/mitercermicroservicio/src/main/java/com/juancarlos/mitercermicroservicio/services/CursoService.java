package com.juancarlos.mitercercroservicio.services;

import java.util.List;

import com.juancarlos.mitercercroservicio.models.Curso;

public interface CursoService {
     List<Curso>  findAll();

     Curso findById(Long id);
    
}
