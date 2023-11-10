package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cursoId; 
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String dia;
    private String horario;
    private int cupo;
    
    @OneToOne
    @JoinColumn(name = "especilidadId", referencedColumnName = "id")
    private Especialidad especialidad;
    
    @OneToOne
    @JoinColumn(name = "profesorId", referencedColumnName = "profesorId")
    private Profesor profesor;

    public Curso() {
    }

    public Curso(int cursoId, String nombre, String descripcion, String ubicacion, String dia, String horario, int cupo, Especialidad especialidad, Profesor profesor) {
        this.cursoId = cursoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.dia = dia;
        this.horario = horario;
        this.cupo = cupo;
        this.especialidad = especialidad;
        this.profesor = profesor;
    }

    

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

   

    
}
