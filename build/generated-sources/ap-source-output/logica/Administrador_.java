package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-06T06:57:22")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Integer> administradorId;
    public static volatile SingularAttribute<Administrador, String> mail;
    public static volatile SingularAttribute<Administrador, String> direccion;
    public static volatile SingularAttribute<Administrador, String> provincia;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, Integer> usuarioId;
    public static volatile SingularAttribute<Administrador, String> pais;
    public static volatile SingularAttribute<Administrador, String> fechaNac;
    public static volatile SingularAttribute<Administrador, String> ciudad;
    public static volatile SingularAttribute<Administrador, String> apellido;
    public static volatile SingularAttribute<Administrador, Usuario> usuario;
    public static volatile SingularAttribute<Administrador, String> telefono;
    public static volatile SingularAttribute<Administrador, String> dni;

}