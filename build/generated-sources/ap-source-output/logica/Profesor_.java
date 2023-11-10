package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-06T06:57:22")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> mail;
    public static volatile SingularAttribute<Profesor, String> direccion;
    public static volatile SingularAttribute<Profesor, String> provincia;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, Integer> usuarioId;
    public static volatile SingularAttribute<Profesor, String> pais;
    public static volatile SingularAttribute<Profesor, String> fechaNac;
    public static volatile SingularAttribute<Profesor, String> ciudad;
    public static volatile SingularAttribute<Profesor, String> apellido;
    public static volatile SingularAttribute<Profesor, Usuario> usuario;
    public static volatile SingularAttribute<Profesor, String> telefono;
    public static volatile SingularAttribute<Profesor, Integer> profesorId;
    public static volatile SingularAttribute<Profesor, String> dni;

}