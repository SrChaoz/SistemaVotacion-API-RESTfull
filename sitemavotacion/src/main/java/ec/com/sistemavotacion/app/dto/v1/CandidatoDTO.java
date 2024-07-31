package ec.com.sistemavotacion.app.dto.v1;

import lombok.Data;

@Data
public class CandidatoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String partido;
    private String cargo;
}
