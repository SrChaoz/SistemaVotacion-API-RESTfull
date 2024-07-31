package ec.com.sistemavotacion.app.api.v1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import ec.com.sistemavotacion.app.domain.Curso;

import ec.com.sistemavotacion.app.persistence.CursoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/cursos")
public class CursoController {
    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return repository.save(curso);
    }
}