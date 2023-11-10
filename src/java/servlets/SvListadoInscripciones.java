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
import logica.Controladora;
import logica.Inscripcion;
import logica.Profesor;
import logica.Usuario;


@WebServlet(name = "SvListadoInscripciones", urlPatterns = {"/SvListadoInscripciones"})
public class SvListadoInscripciones extends HttpServlet {
    Controladora con = new Controladora();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("u");
        Profesor p = con.obtenerProfePorIdUser(usu.getId());
        List<Inscripcion> listaInscripcion = con.obtenerInscripcionesPorProfesor(p.getProfesorId());
        
        session.setAttribute("listaInscripcion", listaInscripcion); 
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/verInscripciones.jsp");
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
