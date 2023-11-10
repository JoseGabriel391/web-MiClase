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
import logica.Inscripcion;
import logica.Profesor;
import logica.Usuario;

@WebServlet(name = "SvAltaInscripcion", urlPatterns = {"/SvAltaInscripcion"})
public class SvAltaInscripcion extends HttpServlet {
    
    Controladora con = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession misesion = request.getSession();
        Usuario usu = (Usuario)misesion.getAttribute("u");
        Profesor p = con.obtenerProfePorIdUser(usu.getId());
        List<Curso> listaCursos = new ArrayList<Curso>();
        //listaCursos = con.getCursos();
        listaCursos = con.obtenerCursoPorProfesor(p.getProfesorId());
        
        misesion.setAttribute("listaCursos", listaCursos); 
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaInscripcion.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("u");
        int id = Integer.parseInt(request.getParameter("alumnoId"));
        int idCurso = Integer.parseInt(request.getParameter("cboCurso"));
        Alumno a = con.obtenerAlumno(id);
        Curso c = con.obtenerCurso(idCurso);
        Profesor p = con.obtenerProfePorIdUser(usu.getId());
        
        con.crearInscripcion(a, c, p );
        response.sendRedirect("SvListadoInscripciones");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
