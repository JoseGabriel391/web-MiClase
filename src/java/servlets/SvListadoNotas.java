
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
import logica.Nota;


@WebServlet(name = "SvListadoNotas", urlPatterns = {"/SvListadoNotas"})
public class SvListadoNotas extends HttpServlet {

    Controladora con = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Nota> lista = con.getNotas();
        
        HttpSession session = request.getSession();
        //session.setAttribute("lista", lista);
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno a = con.obtenerAlumno(id);
        for (Nota nota : lista) {
            System.out.println("Nota: " + nota.getNota() );
        }
        List<Nota> listaPorAlumno = con.getNotasPorAlumno(lista, id);
        session.setAttribute("lista", listaPorAlumno);
        session.setAttribute("alumno", a);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/verNotasDeAlumnos.jsp");
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
