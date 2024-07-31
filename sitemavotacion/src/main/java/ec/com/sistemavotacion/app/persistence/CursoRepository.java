package ec.com.sistemavotacion.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.sistemavotacion.app.domain.Curso;



public interface CursoRepository extends JpaRepository<Curso, Long> {
	
}