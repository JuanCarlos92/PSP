package com.juancarlos.mitercercroservicio.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.juancarlos.mitercercroservicio.models.Curso;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    private List<Curso> data;

    public CursoRepositoryImpl(){
        this.data =  Arrays.asList(
            new Curso(1L,"2DAM", "Mañana"),
            new Curso(2L, "2DAW","Mañana"),
            new Curso(3L, "1DAM", "Tarde"),
            new Curso(4L, "1DAW", "Tarde"));
    }

    @Override
    public List<Curso> findAll() {
        return data;
    }

    @Override
    public Curso findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    
}
