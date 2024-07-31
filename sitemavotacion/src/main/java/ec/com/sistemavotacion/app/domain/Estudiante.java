package ec.com.sistemavotacion.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private MesaElectoral mesaElectoral;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "paralelo_id")
    private Paralelo paralelo;
}