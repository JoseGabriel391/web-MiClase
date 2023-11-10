package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Especialidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-06T06:57:22")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> descripcion;
    public static volatile SingularAttribute<Curso, String> ubicacion;
    public static volatile SingularAttribute<Curso, String> horario;
    public static volatile SingularAttribute<Curso, Integer> cursoId;
    public static volatile SingularAttribute<Curso, Integer> especialidadId;
    public static volatile SingularAttribute<Curso, String> nombre;
    public static volatile SingularAttribute<Curso, String> dia;
    public static volatile SingularAttribute<Curso, Especialidad> especialidad;
    public static volatile SingularAttribute<Curso, Integer> cupo;

}