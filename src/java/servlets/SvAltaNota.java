package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Alumno;
import logica.Controladora;
import logica.Curso;
import logica.Nota;
import logica.Profesor;
import logica.Usuario;

@WebServlet(name = "SvAltaNota", urlPatterns = {"/SvAltaNota"})
public class SvAltaNota extends HttpServlet {

    Controladora con = new Controladora();
    Alumno a = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        a = con.obtenerAlumno(id);
        //List<Curso> listaCursos = con.getCursos();
        HttpSession misesion = request.getSession();
        Usuario usu = (Usuario)misesion.getAttribute("u");
        Profesor p = con.obtenerProfePorIdUser(usu.getId());
        List<Curso> listaCursos = con.obtenerCursoPorProfesor(p.getProfesorId());
        
       
        misesion.setAttribute("listaCursos", listaCursos);
        
       
        
        response.sendRedirect("altaNotas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String descripcion = request.getParameter("descripcion");
        double nota = Double.parseDouble(request.getParameter("nota"));
        int idCurso = Integer.parseInt(request.getParameter("cboCurso"));
       
        HttpSession session = request.getSession();
        
        Usuario usu = (Usuario)session.getAttribute("u");
        
        System.out.println("descripcion " + descripcion);
        System.out.println("nota " + nota);
        System.out.println("alumno " + a.getAlumnoId());
        System.out.println("idUsuario " + usu.getId());
        
        con.crearNota(descripcion, nota, idCurso, usu, a);
        
        int idAlumno = a.getAlumnoId();
        String cadena = "SvListadoNotas?id=" + idAlumno;
        response.sendRedirect(cadena);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
