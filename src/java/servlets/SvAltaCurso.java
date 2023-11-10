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
import logica.Controladora;
import logica.Curso;
import logica.Especialidad;
import logica.Rol;
import logica.Usuario;

@WebServlet(name = "SvAltaCurso", urlPatterns = {"/SvAltaCurso"})
public class SvAltaCurso extends HttpServlet {
    Controladora con = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Especialidad> listaEspecialidad = con.getEspecialidades();
        
        
        HttpSession misesion = request.getSession();
        for (Especialidad l : listaEspecialidad) {
            System.out.println("listaEspecialidad: " + l.getDescripcion());
        }
        misesion.setAttribute("listaEspecialidad", listaEspecialidad);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String ubicacion = request.getParameter("ubicacion");
        String dias = request.getParameter("dias");
        String horario = request.getParameter("horario");
        String cupo = request.getParameter("cupo");
        String especialidad = request.getParameter("cboEspecialidad");
        
        Especialidad esp = con.obtenerEspecialidad(Integer.parseInt(especialidad));
        
        con.crearCurso(nombre, descripcion, ubicacion, dias, horario, Integer.parseInt(cupo), esp);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/verCursos.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
