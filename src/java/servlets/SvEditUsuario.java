
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
import logica.Rol;
import logica.Usuario;


@WebServlet(name = "SvEditUsuario", urlPatterns = {"/SvEditUsuario"})
public class SvEditUsuario extends HttpServlet {

    Controladora con = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usu = con.traerUsuario(id);
        ArrayList<Rol> listaRoles = con.obtenerRoles();
        
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaRoles", listaRoles); 
        for (Rol l : listaRoles) {
            System.out.println("Roles: " + l.getRol());
        }
        
        //response.sendRedirect("altaUsuario.jsp");
       

        misesion.setAttribute("usuEditar", usu);
        
        //response.sendRedirect("editarUsuario.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarUsuario.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("nombreUsu");
        String contrasenia = request.getParameter("contrasenia");
        String idRol = request.getParameter("cboRol");
        Rol rol = con.obtenerRol(Integer.parseInt(idRol));
        
        Usuario usu = (Usuario)request.getSession().getAttribute("usuEditar");
        usu.setUsuario(usuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol.getRol());
        
        con.editarUsuario(usu);
        response.sendRedirect("SvAltaUsuario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
