package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Alumno;
import logica.Controladora;
import logica.Nota;

@WebServlet(name = "SvEliminarNota", urlPatterns = {"/SvEliminarNota"})
public class SvEliminarNota extends HttpServlet {

    Controladora con = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Nota nota = con.obtenerNota(id);
        Alumno a = con.obtenerAlumno(nota.getAlumno().getAlumnoId());
        con.eliminarNota(id);
        
        int idAlumno = a.getAlumnoId();
        String cadena = "SvListadoNotas?id=" + idAlumno;
        response.sendRedirect(cadena);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
