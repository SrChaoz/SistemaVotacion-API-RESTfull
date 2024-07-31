package ec.com.sistemavotacion.app.service.crud;

import ec.com.sistemavotacion.app.domain.MesaElectoral;
import ec.com.sistemavotacion.app.dto.v1.MesaElectoralDTO;
import ec.com.sistemavotacion.app.persistence.MesaElectoralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaElectoralService {

    @Autowired
    private MesaElectoralRepository mesaElectoralRepository;

    public List<MesaElectoralDTO> findAll() {
        return mesaElectoralRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public MesaElectoralDTO find(Long id) {
        return convertToDTO(mesaElectoralRepository.findById(id).orElse(null));
    }

    public MesaElectoralDTO create(MesaElectoralDTO dto) {
        MesaElectoral mesaElectoral = convertToEntity(dto);
        return convertToDTO(mesaElectoralRepository.save(mesaElectoral));
    }

    public MesaElectoralDTO update(MesaElectoralDTO dto) {
        if (mesaElectoralRepository.existsById(dto.getId())) {
            MesaElectoral mesaElectoral = convertToEntity(dto);
            return convertToDTO(mesaElectoralRepository.save(mesaElectoral));
        }
        return null;
    }

    private MesaElectoralDTO convertToDTO(MesaElectoral mesaElectoral) {
        if (mesaElectoral == null) {
            return null;
        }

        MesaElectoralDTO dto = new MesaElectoralDTO();
        dto.setId(mesaElectoral.getId());
        dto.setNombre(mesaElectoral.getNombre());
        dto.setUbicacion(mesaElectoral.getUbicacion());

        return dto;
    }

    private MesaElectoral convertToEntity(MesaElectoralDTO dto) {
        if (dto == null) {
            return null;
        }

        MesaElectoral mesaElectoral = new MesaElectoral();
        mesaElectoral.setId(dto.getId());
        mesaElectoral.setNombre(dto.getNombre());
        mesaElectoral.setUbicacion(dto.getUbicacion());

        return mesaElectoral;
    }
}
