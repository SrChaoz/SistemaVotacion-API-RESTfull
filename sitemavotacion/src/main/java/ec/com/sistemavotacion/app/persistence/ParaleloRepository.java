package ec.com.sistemavotacion.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.com.sistemavotacion.app.domain.Paralelo;

public interface ParaleloRepository extends JpaRepository<Paralelo, Long> {
	
}