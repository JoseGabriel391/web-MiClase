
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


@WebServlet(name="SvEditarInscripcion", urlPatterns={"/SvEditarInscripcion"})
public class SvEditarInscripcion extends HttpServlet {
    
    Controladora con = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Inscripcion i = con.getIncripcion(id); 
        HttpSession misesion = request.getSession();
        Usuario usu = (Usuario)misesion.getAttribute("u");
        Profesor p = con.obtenerProfePorIdUser(usu.getId());
        int cursoSeleccionado = i.getCurso().getCursoId();
        Curso curso = con.obtenerCurso(cursoSeleccionado);
        List<Curso> listaCursos = new ArrayList<Curso>();
        listaCursos = con.obtenerCursoPorProfesor(p.getProfesorId());
        
        misesion.setAttribute("listaCursos", listaCursos); 
        misesion.setAttribute("cursoSeleccionado", curso);
        misesion.setAttribute("insEditar", i);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarInscripcion.jsp");
        rd.forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        int idIns = Integer.parseInt(request.getParameter("idIns"));
        int cboCurso = Integer.parseInt(request.getParameter("cboCurso"));
        
        Curso c = con.obtenerCurso(cboCurso);
        Inscripcion i = con.getIncripcion(idIns);
        //Profesor p = con.obtenerProfe(i.getProfesor().getProfesorId());
        //Alumno a = con.obtenerAlumno(i.getAlumno().getAlumnoId());
        i.setCurso(c);
        
        con.editarInscripcion(i);
        response.sendRedirect("SvListadoInscripciones");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
