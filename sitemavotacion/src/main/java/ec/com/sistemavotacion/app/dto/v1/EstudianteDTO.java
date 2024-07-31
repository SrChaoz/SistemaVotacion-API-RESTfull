package ec.com.sistemavotacion.app.dto.v1;

import lombok.Data;

@Data
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String numTelf;
    private String email;
    private String cedula;
    private String genero;
    private String edad;
    private Float peso;
    private Float altura;
    private CursoDTO curso;
    private ParaleloDTO paralelo;
}
