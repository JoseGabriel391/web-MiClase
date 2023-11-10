package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Alumno;
import logica.Curso;
import logica.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-06T06:57:22")
@StaticMetamodel(Nota.class)
public class Nota_ { 

    public static volatile SingularAttribute<Nota, String> descripcion;
    public static volatile SingularAttribute<Nota, Curso> curso;
    public static volatile SingularAttribute<Nota, Alumno> alumno;
    public static volatile SingularAttribute<Nota, Profesor> profesor;
    public static volatile SingularAttribute<Nota, Double> nota;
    public static volatile SingularAttribute<Nota, Integer> notaId;

}