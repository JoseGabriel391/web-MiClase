package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Inscripcion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inscripcionId;
    
    @OneToOne
    @JoinColumn(name = "profesorId", referencedColumnName = "profesorId")
    private Profesor profesor;
    
    @OneToOne
    @JoinColumn(name = "cursoId", referencedColumnName = "cursoId")
    private Curso curso;
    
    @OneToOne
    @JoinColumn(name = "alumnoId", referencedColumnName = "alumnoId")
    private Alumno alumno;
    
    private String fechaInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(int inscripcionId, Profesor profesor, Curso curso, Alumno alumno, String fechaInscripcion) {
        this.inscripcionId = inscripcionId;
        this.profesor = profesor;
        this.curso = curso;
        this.alumno = alumno;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(int inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
    
}
