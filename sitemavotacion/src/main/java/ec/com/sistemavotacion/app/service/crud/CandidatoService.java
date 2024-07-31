package ec.com.sistemavotacion.app.service.crud;

import ec.com.sistemavotacion.app.domain.Candidato;
import ec.com.sistemavotacion.app.dto.v1.CandidatoDTO;
import ec.com.sistemavotacion.app.persistence.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<CandidatoDTO> findAll() {
        return candidatoRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public CandidatoDTO find(Long id) {
        return convertToDTO(candidatoRepository.findById(id).orElse(null));
    }

    public CandidatoDTO create(CandidatoDTO dto) {
        Candidato candidato = convertToEntity(dto);
        return convertToDTO(candidatoRepository.save(candidato));
    }

    public CandidatoDTO update(CandidatoDTO dto) {
        if (candidatoRepository.existsById(dto.getId())) {
            Candidato candidato = convertToEntity(dto);
            return convertToDTO(candidatoRepository.save(candidato));
        }
        return null;
    }

    private CandidatoDTO convertToDTO(Candidato candidato) {
        if (candidato == null) {
            return null;
        }

        CandidatoDTO dto = new CandidatoDTO();
        dto.setId(candidato.getId());
        dto.setNombre(candidato.getNombre());
        dto.setApellido(candidato.getApellido());
        dto.setPartido(candidato.getPartido());
        dto.setCargo(candidato.getCargo());

        return dto;
    }

    private Candidato convertToEntity(CandidatoDTO dto) {
        if (dto == null) {
            return null;
        }

        Candidato candidato = new Candidato();
        candidato.setId(dto.getId());
        candidato.setNombre(dto.getNombre());
        candidato.setApellido(dto.getApellido());
        candidato.setPartido(dto.getPartido());
        candidato.setCargo(dto.getCargo());

        return candidato;
    }
}
