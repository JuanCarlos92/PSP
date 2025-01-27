package com.juancarlos.misegundomicroservicio.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.juancarlos.misegundomicroservicio.models.Curso;


@Repository
public class CursoRepositoryImpl implements CursoRepository {

    private List<Curso> data;

    public CursoRepositoryImpl() {
        this.data = new ArrayList<>(Arrays.asList(
                new Curso(1L, "2DAM", "Mañana"),
                new Curso(2L, "2DAW", "Mañana"),
                new Curso(3L, "1DAM", "Tarde"),
                new Curso(4L, "1DAW", "Tarde")));
    }

    @Override
    public List<Curso> findAll() {
        return data;
    }

    @Override
    public Curso findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Curso deleteById(Long id) {
        Curso curso = findById(id);
        if (curso != null) {
            data.remove(curso);
        }
        return curso;
    }

    @Override
    public Curso save(Curso curso) {
        Long maxId = data.stream().mapToLong(Curso::getId).max().orElse(0L);
        curso.setId(maxId + 1);
        data.add(curso);
        return curso;
    }
}
