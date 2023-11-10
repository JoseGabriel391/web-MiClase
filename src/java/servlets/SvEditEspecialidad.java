package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Especialidad;

@WebServlet(name = "SvEditEspecialidad", urlPatterns = {"/SvEditEspecialidad"})
public class SvEditEspecialidad extends HttpServlet {
    Controladora con = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Especialidad e = con.traerEspecialidad(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("esEditar", e);
        
        response.sendRedirect("editarEspecialidad.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String descripcion = request.getParameter("especialidad");
        Especialidad e = (Especialidad)request.getSession().getAttribute("esEditar");
        e.setDescripcion(descripcion);
        
        con.editarEspecialidad(e);
        response.sendRedirect("SvEspecialidad");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
