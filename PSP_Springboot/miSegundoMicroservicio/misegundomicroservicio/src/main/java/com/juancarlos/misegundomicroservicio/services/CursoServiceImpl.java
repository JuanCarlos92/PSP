package com.juancarlos.misegundomicroservicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.misegundomicroservicio.models.Curso;
import com.juancarlos.misegundomicroservicio.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository repository;

    @Override
    public List<Curso> findAll() {
        return repository.findAll();
    }
        
    @Override
    public Curso findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Curso deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return repository.save(curso);
    }


    
}
