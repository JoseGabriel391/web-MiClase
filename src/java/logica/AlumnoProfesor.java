
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AlumnoProfesor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumnoProfesorId;
    @OneToOne
    @JoinColumn(name = "alumnoId", referencedColumnName = "alumnoId")
    private Alumno alumno;
    @OneToOne
    @JoinColumn(name = "profesorId", referencedColumnName = "profesorId")
    private Profesor profesor;

    public AlumnoProfesor() {
    }

    public AlumnoProfesor(int alumnoProfesorId, Alumno alumno, Profesor profesor) {
        this.alumnoProfesorId = alumnoProfesorId;
        this.alumno = alumno;
        this.profesor = profesor;
    }

    public int getAlumnoProfesorId() {
        return alumnoProfesorId;
    }

    public void setAlumnoProfesorId(int alumnoProfesorId) {
        this.alumnoProfesorId = alumnoProfesorId;
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
    
    
}
