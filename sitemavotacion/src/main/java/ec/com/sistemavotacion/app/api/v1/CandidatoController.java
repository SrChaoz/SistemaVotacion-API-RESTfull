package ec.com.sistemavotacion.app.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.com.sistemavotacion.app.domain.Candidato;
import ec.com.sistemavotacion.app.persistence.CandidatoRepository;

@RestController
@RequestMapping("/api/v1.0/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoRepository repository;

    @GetMapping
    public List<Candidato> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Candidato create(@RequestBody Candidato candidato) {
        return repository.save(candidato);
    }
}