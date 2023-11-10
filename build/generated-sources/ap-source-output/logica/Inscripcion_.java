package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Alumno;
import logica.Curso;
import logica.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-06T06:57:22")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, Integer> inscripcionId;
    public static volatile SingularAttribute<Inscripcion, Curso> curso;
    public static volatile SingularAttribute<Inscripcion, Profesor> profesor;
    public static volatile SingularAttribute<Inscripcion, Alumno> alumno;

}