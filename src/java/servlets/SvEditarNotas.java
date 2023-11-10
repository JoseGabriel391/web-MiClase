package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "SvEditarNotas", urlPatterns = {"/SvEditarNotas"})
public class SvEditarNotas extends HttpServlet {
    
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
        Nota nota = con.obtenerNota(id);
        int cursoSeleccionado = nota.getCurso().getCursoId();
        Curso curso = con.obtenerCurso(cursoSeleccionado);
        System.out.println("IdCurso: " + cursoSeleccionado);
        //List<Curso> listaCursos = con.getCursos();
        HttpSession misesion = request.getSession();
        Usuario usu = (Usuario)misesion.getAttribute("u");
        Profesor p = con.obtenerProfePorIdUser(usu.getId());
        List<Curso> listaCursos = con.obtenerCursoPorProfesor(p.getProfesorId());
        
        misesion.setAttribute("listaCursos", listaCursos); 
        misesion.setAttribute("notasEditar", nota);
        misesion.setAttribute("cursoSeleccionado", curso);
        
        //response.sendRedirect("altaNotas.jsp");
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarNota.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        double nota = Double.parseDouble(request.getParameter("nota"));
        int idCurso = Integer.parseInt(request.getParameter("cboCurso"));
        Curso c = con.obtenerCurso(idCurso);
       
        HttpSession session = request.getSession();
        Nota n = (Nota)request.getSession().getAttribute("notasEditar");
        n.setDescripcion(descripcion);
        n.setNota(nota);
        n.setCurso(c);
        
        con.editarNota(n);
        
        int idAlumno = n.getAlumno().getAlumnoId();
        String cadena = "SvListadoNotas?id=" + idAlumno;
        response.sendRedirect(cadena);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
