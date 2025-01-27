package com.juancarlos.mitercercroservicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.mitercercroservicio.models.Curso;
import com.juancarlos.mitercercroservicio.repositories.CursoRepository;

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
    
}
