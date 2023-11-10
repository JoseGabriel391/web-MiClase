
package servlets;

import java.io.IOException;
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
import logica.Usuario;
import logica.Rol;


@WebServlet(name = "SvAltaUsuario", urlPatterns = {"/SvAltaUsuario"})
public class SvAltaUsuario extends HttpServlet {
    Controladora con = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = con.getUsuarios();
        
        ArrayList<Rol> listaRoles = con.obtenerRoles();
        
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaRoles", listaRoles); 
        for (Rol l : listaRoles) {
            System.out.println("Roles: " + l.getRol());
        }
        misesion.setAttribute("listaUsuarios", listaUsuarios);
        
        //response.sendRedirect("altaUsuario.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaUsuario.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombreUsu");
        String contrasenia = request.getParameter("contrasenia");
        String idRol = request.getParameter("cboRol");
        
        Rol rol = con.obtenerRol(Integer.parseInt(idRol));
        con.crearUsuario(nombre, contrasenia, rol.getRol());
        response.sendRedirect("SvListadoUsuario");

        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
