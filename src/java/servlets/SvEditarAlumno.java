package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Alumno;
import logica.Controladora;

@WebServlet(name = "SvEditarAlumno", urlPatterns = {"/SvEditarAlumno"})
public class SvEditarAlumno extends HttpServlet {
    Controladora con = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno a = con.obtenerAlumno(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("aluEditar", a);
        
        response.sendRedirect("editarAlumno.jsp");
        
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
        Alumno a = (Alumno)request.getSession().getAttribute("aluEditar");
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
        
        con.editarAlumno(a);
        response.sendRedirect("SvListadoAlumnos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
