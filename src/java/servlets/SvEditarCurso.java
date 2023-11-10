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
import logica.Rol;
import logica.Especialidad;

@WebServlet(name = "SvEditarCurso", urlPatterns = {"/SvEditarCurso"})
public class SvEditarCurso extends HttpServlet {
    
    Controladora con = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        Curso c = con.traerCurso(id);
        Especialidad e = con.traerEspecialidad(id);
        
        List<Especialidad> listaEspecialidad = con.getEspecialidades();
        
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaEspecialidad", listaEspecialidad); 
        

        misesion.setAttribute("curEditar", c);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarCurso.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("decripcion");
        String dia = request.getParameter("dia");
        String horario = request.getParameter("horario");
        String ubicacion = request.getParameter("ubicacion");
        String cupo = request.getParameter("cupo");
        int idEsp = Integer.parseInt(request.getParameter("cboEspecialidad"));
        
        Especialidad esp = con.obtenerEspecialidad(idEsp);
        
        Curso c = (Curso)request.getSession().getAttribute("curEditar");
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        c.setCupo(Integer.parseInt(cupo));
        c.setDia(dia);
        c.setHorario(horario);
        c.setUbicacion(ubicacion);
        c.setEspecialidad(esp);
        
        
        con.editarCurso(c);
        response.sendRedirect("SvListadoCursos");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
