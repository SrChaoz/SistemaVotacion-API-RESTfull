package ec.com.sistemavotacion.app.service.crud;

import ec.com.sistemavotacion.app.domain.Curso;
import ec.com.sistemavotacion.app.domain.Estudiante;
import ec.com.sistemavotacion.app.domain.Paralelo;
import ec.com.sistemavotacion.app.dto.v1.CursoDTO;
import ec.com.sistemavotacion.app.dto.v1.EstudianteDTO;
import ec.com.sistemavotacion.app.dto.v1.ParaleloDTO;
import ec.com.sistemavotacion.app.persistence.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public EstudianteDTO find(Long id) {
        return convertToDTO(estudianteRepository.findById(id).orElse(null));
    }

    public EstudianteDTO create(EstudianteDTO dto) {
        Estudiante estudiante = convertToEntity(dto);
        return convertToDTO(estudianteRepository.save(estudiante));
    }

    public EstudianteDTO update(EstudianteDTO dto) {
        if (estudianteRepository.existsById(dto.getId())) {
            Estudiante estudiante = convertToEntity(dto);
            return convertToDTO(estudianteRepository.save(estudiante));
        }
        return null;
    }

    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setNumTelf(estudiante.getNumTelf());
        dto.setEmail(estudiante.getEmail());
        dto.setCedula(estudiante.getCedula());
        dto.setGenero(estudiante.getGenero());
        dto.setEdad(estudiante.getEdad());
        dto.setPeso(estudiante.getPeso());
        dto.setAltura(estudiante.getAltura());
        dto.setCurso(estudiante.getCurso() != null ? convertCursoToDTO(estudiante.getCurso()) : null);
        dto.setParalelo(estudiante.getParalelo() != null ? convertParaleloToDTO(estudiante.getParalelo()) : null);

        return dto;
    }

    private CursoDTO convertCursoToDTO(Curso curso) {
        if (curso == null) {
            return null;
        }
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        return dto;
    }

    private ParaleloDTO convertParaleloToDTO(Paralelo paralelo) {
        if (paralelo == null) {
            return null;
        }
        ParaleloDTO dto = new ParaleloDTO();
        dto.setId(paralelo.getId());
        dto.setNombre(paralelo.getNombre());
        return dto;
    }

    private Estudiante convertToEntity(EstudianteDTO dto) {
        if (dto == null) {
            return null;
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setId(dto.getId());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setNumTelf(dto.getNumTelf());
        estudiante.setEmail(dto.getEmail());
        estudiante.setCedula(dto.getCedula());
        estudiante.setGenero(dto.getGenero());
        estudiante.setEdad(dto.getEdad());
        estudiante.setPeso(dto.getPeso());
        estudiante.setAltura(dto.getAltura());
        // Assuming Curso and Paralelo are being handled separately.
        return estudiante;
    }
}
