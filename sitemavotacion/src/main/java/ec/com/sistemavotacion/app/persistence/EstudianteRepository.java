package ec.com.sistemavotacion.app.persistence;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.sistemavotacion.app.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
}