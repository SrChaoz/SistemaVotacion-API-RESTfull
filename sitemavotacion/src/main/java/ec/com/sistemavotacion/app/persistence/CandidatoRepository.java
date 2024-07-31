package ec.com.sistemavotacion.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.sistemavotacion.app.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {}