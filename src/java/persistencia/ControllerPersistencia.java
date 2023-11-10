
package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Administrador;
import logica.Alumno;
import logica.AlumnoProfesor;
import logica.Curso;
import logica.Especialidad;
import logica.Inscripcion;
import logica.Nota;
import logica.Profesor;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;


public class ControllerPersistencia {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    EspecialidadJpaController es = new EspecialidadJpaController();
    AdministradorJpaController admJpa = new AdministradorJpaController();
    ProfesorJpaController proJpa = new ProfesorJpaController();
    AlumnoJpaController aJpa = new AlumnoJpaController();
    CursoJpaController cJpa = new CursoJpaController();
    NotasJpaController nJpa = new NotasJpaController();
    InscripcionJpaController ijc = new InscripcionJpaController();
    AlumnoProfesorJpaController apjc = new AlumnoProfesorJpaController();

    public ControllerPersistencia() {
    }

    public void crearUsuario(Usuario u) {
        usuJpa.create(u);
    }

    public List<Usuario> getUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    public void eliminarUsuario(int id) {
        try {
            usuJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return usuJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearEspecialidad(Especialidad especialidad) {
        es.create(especialidad);
    }

    public List<Especialidad> getEspecialidades() {
        return es.findEspecialidadEntities();
    }

    public void eliminarEspecialidad(int id) {
        try {
            es.destroy(id);
        }catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public Especialidad traerEspecialidad(int id) {
        return es.findEspecialidad(id);
    }

    public void editarEspecialidad(Especialidad e) {
        try {
            es.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearAdmin(Administrador a) {
        admJpa.create(a);
    }

    public List<Administrador> getAdministradores() {
        return admJpa.findAdministradorEntities();
    }

    public void eliminarAdmin(int id) {
        try {
            admJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Administrador obtenerAdmin(int id) {
        return admJpa.findAdministrador(id);
    }

    public void editarAdministrador(Administrador a) {
        try {
            admJpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearProfe(Profesor profe) {
        try {
            proJpa.create(profe);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Profesor> getProfesores() {
        return proJpa.findProfesorEntities();
    }

    public void eliminarProfe(int id) {
        try {
            proJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Profesor obtenerProfe(int id) {
        return proJpa.findProfesor(id);
    }

    public void editarProfesor(Profesor p) {
        try {
            proJpa.edit(p);
        }  catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearAlumno(Alumno a) {
        try {
            aJpa.create(a);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Alumno> getAlumnos() {
        return aJpa.findAlumnoEntities();
    }

    public void eliminarAlumno(int id) {
        try {
            aJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno obtenerAlumno(int id) {
        return aJpa.findAlumno(id);
    }

    public void editarAlumno(Alumno a) {
        try {
            aJpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCurso(Curso c) {
        try {
            cJpa.create(c);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Curso> getCursos() {
        return cJpa.findCursoEntities();
    }

    public void eliminarCurso(int id) {
        try {
            cJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Curso traerCurso(int id) {
        return cJpa.findCurso(id);
    }

    public void editarCurso(Curso c) {
        try {
            cJpa.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Curso obtenerCurso(int idCurso) {
        return cJpa.findCurso(idCurso);
    }

    public void crearNota(Nota n) {
        try {
            nJpa.create(n);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Nota obtenerNota(int id) {
        return nJpa.findNotas(id);
    }

    public void editarNota(Nota n) {
        try { 
            nJpa.edit(n);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Nota> getNotas() {
        return nJpa.findNotasEntities();
    }

    public void eliminarNota(int id) {
        try {
            nJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearInscripcion(Inscripcion i) {
        try {
            ijc.create(i);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario obtenerUser(int id) {
        return usuJpa.findUsuario(id);
    }

    public void crearAlumnoProfesor(AlumnoProfesor ap) {
        try {
            apjc.create(ap);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarInscripcion(int id) {
        try {
            ijc.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Inscripcion getInscripcion(int id) {
        return ijc.findInscripcion(id);
    }

    public void editarInscripcion(Inscripcion i) {
        try {
            ijc.edit(i);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

 

    
    
    
}
