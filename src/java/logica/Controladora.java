package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.Nota;
import persistencia.ControllerPersistencia;

public class Controladora {
    private Connection conn;
    private final String cadena = "jdbc:sqlserver://localhost:1433;databaseName=miclase";
    private final String user = "sa";
    private final String pass = "123";
    ControllerPersistencia con = new ControllerPersistencia();
    Date fechaActual = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm.ss");
    String fechaFormateada = formato.format(fechaActual);
    
    private void abrirConexion(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(cadena, user, pass);
            System.out.println("Conexion abierta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void cerrarConexion(){
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario crearUsuario(String nombre, String contrasenia, String rol) {
        Usuario u = new Usuario();
        u.setUsuario(nombre);
        u.setContrasenia(contrasenia);
        u.setRol(rol);
        con.crearUsuario(u);
        return u;
    }

    public List<Usuario> getUsuarios() {
        return con.getUsuarios();
    }

    public void eliminarUsuario(int id) {
        con.eliminarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return con.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        con.editarUsuario(usu);
    }

    public boolean comprobarIngreso(String usuario, String pass) {
        boolean ingreso = false;
        Usuario usu = new Usuario();
        List<Usuario> lista = new ArrayList<Usuario>();
        lista = con.getUsuarios();
        
        for (Usuario u : lista) {
            if(u.getUsuario().equals(usuario)){
                if(u.getContrasenia().equals(pass)){
                    ingreso = true;
                    break;
                }else{
                    ingreso = false;
                }
            }
        }
        System.out.println("Ingreso:" + ingreso);
        return ingreso;
    }
    
     public Usuario obtenerUsuario(String usuario, String pass) {
        boolean ingreso = false;
        Usuario usu = new Usuario();
        List<Usuario> lista = new ArrayList<Usuario>();
        lista = con.getUsuarios();
        
        for (Usuario u : lista) {
            if(u.getUsuario().equals(usuario)){
                if(u.getContrasenia().equals(pass)){
                    usu = u;
                    break;
                }
            }
        }
        System.out.println("Ingreso:" + ingreso);
        return usu;
    }

    public void crearEspecialidad(String descripcion) {
        Especialidad e = new Especialidad();
        e.setDescripcion(descripcion);
        con.crearEspecialidad(e);
    }
   
    public List<Especialidad> getEspecialidades() {
        return con.getEspecialidades();
    }

    public void eliminarEspecialidad(int id) {
        con.eliminarEspecialidad(id);
    }

    public Especialidad traerEspecialidad(int id) {
        return con.traerEspecialidad(id);
    }

    public void editarEspecialidad(Especialidad e) {
         con.editarEspecialidad(e);
    }

    public Rol obtenerRol(int idRol) {
        Rol resultado = null;
        
        try {
            abrirConexion();
            String sql = "select * from rol where id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRol);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String rol = rs.getString("rol");
                resultado = new Rol(idRol, rol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public ArrayList<Rol> obtenerRoles(){
        ArrayList<Rol> lista = new ArrayList<Rol>();
        
        try {
            abrirConexion();
            String sql = "select * from rol;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String rol = rs.getString("rol");
                
                lista.add(new Rol(id, rol));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return lista;
    }

    public Administrador crearAdmin(String nombre, String apellido, String dni, String direccion, String pais, String provincia, String ciudad, String fecNac, String telefono, String mail, int usuarioId) {
       Administrador a = new Administrador();
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setDni(dni);
        a.setPais(pais);
        a.setProvincia(provincia);
        a.setCiudad(ciudad);
        a.setDireccion(direccion);
        a.setFechaNac(fecNac);
        a.setTelefono(telefono);
        a.setMail(mail);
        a.setUsuarioId(usuarioId);
        
        con.crearAdmin(a);
        return a;
    }

    public List<Administrador> getAdministradores() {
         return con.getAdministradores();
    }

    public void eliminarAdmin(int id) {
        con.eliminarAdmin(id);
    }

    public Administrador obtenerAdmin(int id) {
       return con.obtenerAdmin(id);
    }

    public void editarAdministrador(Administrador a) {
        con.editarAdministrador(a);
    }

    public Profesor crearProfe(String nombre, String apellido, String dni, String direccion, String pais, String provincia, String ciudad, String fecNac, String telefono, String mail, Usuario usuario) {
        Profesor profe = new Profesor();
        profe.setNombre(nombre);
        profe.setApellido(apellido);
        profe.setDni(dni);
        profe.setPais(pais);
        profe.setProvincia(provincia);
        profe.setCiudad(ciudad);
        profe.setDireccion(direccion);
        profe.setFechaNac(fecNac);
        profe.setTelefono(telefono);
        profe.setMail(mail);
        profe.setUsuario(usuario);
        
        con.crearProfe(profe);
        return profe;
    }

    public List<Profesor> getProfesores() {
        return con.getProfesores();
    }

    public void eliminarProfe(int id) {
        con.eliminarProfe(id);
    }

    public Profesor obtenerProfe(int id) {
        return con.obtenerProfe(id);
    }
    
    public Profesor obtenerProfePorIdUser(int id) {
        Profesor p = new Profesor();
        try {
            abrirConexion();
            String sql = "select * from profesor where usuarioId = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int profesorId = rs.getInt("profesorId");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String fechaNac = rs.getString("fechaNac");
                String direccion = rs.getString("direccion");
                String pais = rs.getString("pais");
                String provincia = rs.getString("provincia");
                String ciudad = rs.getString("ciudad");
                String telefono = rs.getString("telefono");
                String mail = rs.getString("mail");
                Usuario usuario = con.obtenerUser(id);
               
                
                p = new Profesor(profesorId, nombre, apellido, dni, fechaNac, direccion, pais, provincia, ciudad, telefono, mail, usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public void editarProfesor(Profesor a) {
        con.editarProfesor(a);
    }

    public Alumno crearAlumno(String nombre, String apellido, String dni, String direccion, String pais, String provincia, String ciudad, String fecNac, String telefono, String mail, Usuario usuario) {
        Alumno a = new Alumno();
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setDni(dni);
        a.setFechaNac(fecNac);
        a.setPais(pais);
        a.setProvincia(provincia);
        a.setCiudad(ciudad);
        a.setDireccion(direccion);
        a.setTelefono(telefono);
        a.setMail(mail);
        a.setUsuario(usuario);
        
        con.crearAlumno(a);
        return a;
    }

    public List<Alumno> getAlumnos() {
        return con.getAlumnos();
    }
    
    public List<Alumno> obtenerAlumnosPorProfesor(){
        List<Alumno> lista = new ArrayList<Alumno>();
        try{
            abrirConexion();
            String sql = "select a.* from ALUMNO a join ALUMNOPROFESOR ap\n" +
                         "on a.ALUMNOID = ap.alumnoId join PROFESOR p on p.profesorID = ap.profesorId;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                    int id = rs.getInt("alumnoId");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String dni = rs.getString("dni");
                    String ciudad = rs.getString("ciudad");
                    String provincia = rs.getString("provincia");
                    String pais = rs.getString("pais");
                    String direccion = rs.getString("direccion");
                    String fechaNac = rs.getString("fechaNac");
                    String telefono = rs.getString("telefono");
                    String mail = rs.getString("mail");
                    int usuarioId = rs.getInt("usuarioId");
                    Usuario usuario = traerUsuario(usuarioId);
                    
                    lista.add(new Alumno(id, nombre, apellido, dni, fechaNac, direccion, pais, provincia, ciudad, telefono, mail, usuario));
            }
        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            cerrarConexion();
        }
        return lista;
    }

    public void eliminarAlumno(int id) {
        con.eliminarAlumno(id);
    }

    public Alumno obtenerAlumno(int id) {
        return con.obtenerAlumno(id);
    }

    public void editarAlumno(Alumno a) {
        con.editarAlumno(a);
    }

    public void crearCurso(String nombre, String descripcion, String ubicacion, String dias, String horario, int cupo, Especialidad especialidad) {
        Curso c = new Curso();
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        c.setUbicacion(ubicacion);
        c.setDia(dias);
        c.setHorario(horario);
        c.setCupo(cupo);
        c.setEspecialidad(especialidad);
        con.crearCurso(c);
    }

    public Especialidad obtenerEspecialidad(int especialidad) {
        Especialidad resultado = null;
        
         try {
            abrirConexion();
            String sql = "select * from especialidad where id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, especialidad);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String descripcion = rs.getString("descripcion");
                resultado = new Especialidad(especialidad, descripcion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return resultado;
    }

    public List<Curso> getCursos() {
        return con.getCursos();
    }
    
    public List<Curso> obtenerCursoPorProfesor(int id){
        List<Curso> lista = new ArrayList<Curso>();
        
        try {
         abrirConexion();
         String sql = "select c.* from curso c join profesor p on c.profesorId = p.profesorId where c.profesorId = ?;";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
             int cursoId = rs.getInt("cursoId");
             int cupo = rs.getInt("cupo");
             String descripcion = rs.getString("descripcion");
             String dia = rs.getString("dia");
             String horario = rs.getString("horario");
             String nombre = rs.getString("nombre");
             String ubicacion = rs.getString("ubicacion");
             int especialidadId = rs.getInt("especilidadId");
             int profesorId = rs.getInt("profesorId");
             
             Especialidad e = obtenerEspecialidad(especialidadId);
             Profesor p = obtenerProfe(profesorId);
             
             lista.add(new Curso(cursoId, nombre, descripcion, ubicacion, dia, horario, cupo, e, p));
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminarCurso(int id) {
        con.eliminarCurso(id);
    }

    public void editarCurso(Curso c) {
        con.editarCurso(c);
    }

    public Curso traerCurso(int id) {
        return con.traerCurso(id);
    }

    public void crearNota(String descripcion, double nota, int idCurso, Usuario usu, Alumno a) {
        Nota n = new Nota();
        Curso c = con.obtenerCurso(idCurso);
        Profesor p = obtenerProfePorIdUser(usu.getId());
        n.setDescripcion(descripcion);
        n.setNota(nota);
        n.setCurso(c);
        n.setProfesor(p);
        n.setAlumno(a);
        System.out.println("curso " + c.getCursoId());
        System.out.println("profesor " + p.getProfesorId());
        con.crearNota(n);
    }

     public Curso obtenerCurso(int idCurso) {
        return con.obtenerCurso(idCurso);
    }

    public Nota obtenerNota(int id) {
        return con.obtenerNota(id);
    }

    public void editarNota(Nota n) {
        con.editarNota(n);
    }

    public List<Nota> getNotas() {
        return con.getNotas();
    }

    public List<Nota> getNotasPorAlumno(List<Nota> lista, int id) {
        List<Nota> resultado = new ArrayList<Nota>();
        
        try {
            abrirConexion();
            for (Nota nota : lista) {
                System.out.println("Entra al for");
                if(nota != null){
                    System.out.println("Nota no es null");
                }else{
                    System.out.println("Nota es null");
                }
                
                if(nota != null && nota.getAlumno().getAlumnoId() == id){
                    resultado.add(nota);
                }else{
                    System.out.println("Nota es null");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void eliminarNota(int id) {
        con.eliminarNota(id);
    }

    public void crearInscripcion(Alumno a, Curso c, Profesor p) {
        Inscripcion i = new Inscripcion();
        i.setAlumno(a);
        i.setCurso(c);
        i.setProfesor(p);
        i.setFechaInscripcion(fechaFormateada);
        con.crearInscripcion(i);
    }

    public AlumnoProfesor crearAlumnoProfesor(Alumno alumno, Profesor profesor) {
       AlumnoProfesor ap = new AlumnoProfesor();
       ap.setAlumno(alumno);
       ap.setProfesor(profesor);
       con.crearAlumnoProfesor(ap);
       return ap;
    }

    public List<Inscripcion> obtenerInscripcionesPorProfesor(int profesorId) {
        List<Inscripcion> lista = new ArrayList<Inscripcion>();
        try {
            abrirConexion();
            String sql = "select i.* from inscripcion i join profesor p on i.profesorId = p.PROFESORID\n" +
                         "where i.profesorId = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, profesorId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Inscripcion i = new Inscripcion();
                int id = rs.getInt("inscripcionId");
                String fecha = rs.getString("fechaInscripcion");
                int alumnoId = rs.getInt("alumnoId");
                int cursoId = rs.getInt("cursoId");
                int idProfe = rs.getInt("profesorId");
                
                Alumno a = obtenerAlumno(alumnoId);
                Curso c = obtenerCurso(cursoId);
                Profesor p = obtenerProfe(idProfe);
                
                lista.add(new Inscripcion(id, p, c, a, fecha));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            cerrarConexion();
        }
        return lista;
    }

    public void eliminarInscripcion(int id) {
        con.eliminarInscripcion(id);
    }

    public Inscripcion getIncripcion(int id) {
        return con.getInscripcion(id);
    }

    public void editarInscripcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editarInscripcion(Inscripcion i) {
        con.editarInscripcion(i);
    }

}
