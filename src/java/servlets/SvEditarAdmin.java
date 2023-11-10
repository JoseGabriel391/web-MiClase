package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Administrador;
import logica.Controladora;


@WebServlet(name = "SvEditarAdmin", urlPatterns = {"/SvEditarAdmin"})
public class SvEditarAdmin extends HttpServlet {

    Controladora con = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Administrador a = con.obtenerAdmin(id);
          
        HttpSession misession = request.getSession();
        misession.setAttribute("admEditar", a);
        
        response.sendRedirect("editarAdmin.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String pais = request.getParameter("pais");
        String provincia = request.getParameter("provincia");
        String ciudad = request.getParameter("ciudad");
        String fecNac = request.getParameter("fechaNac");
        String telefono = request.getParameter("telefono");
        String mail = request.getParameter("mail");
        Administrador a = (Administrador)request.getSession().getAttribute("admEditar");
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setDni(dni);
        a.setCiudad(ciudad);
        a.setPais(pais);
        a.setProvincia(provincia);
        a.setDireccion(direccion);
        a.setTelefono(telefono);
        a.setMail(mail);
        a.setFechaNac(fecNac);
        
        con.editarAdministrador(a);
        response.sendRedirect("svListadoAdmin");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
