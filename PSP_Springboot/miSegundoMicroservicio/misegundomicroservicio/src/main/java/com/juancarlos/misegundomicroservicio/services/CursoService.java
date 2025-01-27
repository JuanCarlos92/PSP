package com.juancarlos.misegundomicroservicio.services;

import java.util.List;

import com.juancarlos.misegundomicroservicio.models.Curso;

public interface CursoService {
     List<Curso>  findAll();

     Curso findById(Long id);

     Curso deleteById(Long id);

     Curso save(Curso curso);
    
}
