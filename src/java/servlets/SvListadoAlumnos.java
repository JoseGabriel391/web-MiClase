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


@WebServlet(name = "SvListadoAlumnos", urlPatterns = {"/SvListadoAlumnos"})
public class SvListadoAlumnos extends HttpServlet {

    Controladora con = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        //listaAlumnos = con.getAlumnos();
        listaAlumnos = con.obtenerAlumnosPorProfesor();
        
        HttpSession misesion = request.getSession();
       
        misesion.setAttribute("listaAlumnos", listaAlumnos);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/verAlumnos.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
