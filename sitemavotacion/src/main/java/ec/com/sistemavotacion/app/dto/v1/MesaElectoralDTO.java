package ec.com.sistemavotacion.app.dto.v1;

import lombok.Data;

@Data
public class MesaElectoralDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
}
