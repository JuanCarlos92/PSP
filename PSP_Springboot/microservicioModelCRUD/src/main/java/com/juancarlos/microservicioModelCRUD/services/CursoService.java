package com.juancarlos.microservicioModelCRUD.services;

import java.util.List;

import com.juancarlos.microservicioModelCRUD.models.Curso;

public interface CursoService {
     List<Curso>  findAll();

     Curso findById(Long id);

     Curso deleteById(Long id);

     Curso save(Curso curso);
    
}
