package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Nota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notaId;
    private double nota;
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "alumnoId", referencedColumnName = "alumnoId")
    private Alumno alumno;
    @OneToOne
    @JoinColumn(name = "profesorId", referencedColumnName = "profesorId")
    private Profesor profesor;
    @OneToOne
    @JoinColumn(name = "cursoId", referencedColumnName = "cursoId")
    private Curso curso;

    public Nota() {
    }

    public Nota(int notaId, double nota, String descripcion, Alumno alumno, Profesor profesor, Curso curso) {
        this.notaId = notaId;
        this.nota = nota;
        this.descripcion = descripcion;
        this.alumno = alumno;
        this.profesor = profesor;
        this.curso = curso;
    }

    public int getNotaId() {
        return notaId;
    }

    public void setNotaId(int notaId) {
        this.notaId = notaId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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

    
    
}
