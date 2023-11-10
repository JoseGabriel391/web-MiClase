package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Profesor;
import logica.Rol;
import logica.Usuario;

@WebServlet(name = "SvAltaProfesor", urlPatterns = {"/SvAltaProfesor"})
public class SvAltaProfesor extends HttpServlet {

    Controladora con = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Rol> listaRoles = con.obtenerRoles();
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaRoles", listaRoles);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaProfesor.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creo primero el usuario
        String nombreUsuario = request.getParameter("nombreUsu");
        String contrasenia = request.getParameter("contrasenia");
        String idRol = request.getParameter("cboRol");
        
        Rol rol = con.obtenerRol(Integer.parseInt(idRol));
        Usuario u = con.crearUsuario(nombreUsuario, contrasenia, rol.getRol());
        
        //Segundo creo al admin
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
        
        Profesor profe = con.crearProfe(nombre, apellido, dni, direccion, pais, provincia, ciudad, fecNac, telefono, mail, u);
        //admin.setUsuarioId(u.getId());
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
