package ec.com.sistemavotacion.app.api.v1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import ec.com.sistemavotacion.app.domain.Paralelo;

import ec.com.sistemavotacion.app.persistence.ParaleloRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/paralelos")
public class ParaleloController {
    @Autowired
    private ParaleloRepository repository;

    @GetMapping
    public List<Paralelo> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Paralelo create(@RequestBody Paralelo paralelo) {
        return repository.save(paralelo);
    }
}
