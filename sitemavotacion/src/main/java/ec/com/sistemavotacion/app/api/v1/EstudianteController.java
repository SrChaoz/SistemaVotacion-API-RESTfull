package ec.com.sistemavotacion.app.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.sistemavotacion.app.domain.Estudiante;
import ec.com.sistemavotacion.app.persistence.EstudianteRepository;

@RestController
@RequestMapping("/api/v1.0/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteRepository repository;

    @GetMapping
    public List<Estudiante> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return repository.save(estudiante);
    }
}