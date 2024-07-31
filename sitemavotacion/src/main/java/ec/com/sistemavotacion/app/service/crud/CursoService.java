package ec.com.sistemavotacion.app.service.crud;

import ec.com.sistemavotacion.app.domain.Curso;
import ec.com.sistemavotacion.app.dto.v1.CursoDTO;
import ec.com.sistemavotacion.app.persistence.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> findAll() {
        return cursoRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public CursoDTO find(Long id) {
        return convertToDTO(cursoRepository.findById(id).orElse(null));
    }

    public CursoDTO create(CursoDTO dto) {
        Curso curso = convertToEntity(dto);
        return convertToDTO(cursoRepository.save(curso));
    }

    public CursoDTO update(CursoDTO dto) {
        if (cursoRepository.existsById(dto.getId())) {
            Curso curso = convertToEntity(dto);
            return convertToDTO(cursoRepository.save(curso));
        }
        return null;
    }

    private CursoDTO convertToDTO(Curso curso) {
        if (curso == null) {
            return null;
        }

        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());

        return dto;
    }

    private Curso convertToEntity(CursoDTO dto) {
        if (dto == null) {
            return null;
        }

        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNombre(dto.getNombre());

        return curso;
    }
}
