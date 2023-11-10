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
import logica.Profesor;
import logica.Usuario;


@WebServlet(name = "SvListadoCursos", urlPatterns = {"/SvListadoCursos"})
public class SvListadoCursos extends HttpServlet {

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
        List<Curso> lista = new ArrayList<Curso>();
        if(usu != null){
            Profesor p = con.obtenerProfePorIdUser(usu.getId());
            lista = con.obtenerCursoPorProfesor(p.getProfesorId());
        }
        
        
        //lista = con.getCursos();
        
        
        //HttpSession misesion = request.getSession();
       
        misesion.setAttribute("lista", lista);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/verCursos.jsp");
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
