package ec.com.sistemavotacion.app.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.sistemavotacion.app.domain.MesaElectoral;


public interface MesaElectoralRepository extends JpaRepository<MesaElectoral, Long> {
	
}