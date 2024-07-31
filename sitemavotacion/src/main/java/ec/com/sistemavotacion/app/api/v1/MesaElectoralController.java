package ec.com.sistemavotacion.app.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.com.sistemavotacion.app.domain.MesaElectoral;
import ec.com.sistemavotacion.app.persistence.MesaElectoralRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/mesas")
public class MesaElectoralController {
    @Autowired
    private MesaElectoralRepository repository;

    @GetMapping
    public List<MesaElectoral> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public MesaElectoral create(@RequestBody MesaElectoral mesa) {
        return repository.save(mesa);
    }
}