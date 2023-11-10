<%@page import="logica.Inscripcion"%>
<%@page import="logica.Curso"%>
<%@page import="logica.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
    

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Inscripciones</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Legajo</th>
                            <th>Nombre</th>
                            <th>DNI</th>
                            <th>Curso</th>
                            <th>Dias</th>
                            <th>Horario</th>
                            <th style="width:210px">Accion</th>
                        </tr>
                    </thead>
                    <%
                        List<Inscripcion> listaInscripcion = (List<Inscripcion>) request.getSession().getAttribute("listaInscripcion");
                       
                    %>
                    <tbody>
                        <% for (Inscripcion a : listaInscripcion) {%>
                        <tr>
                            <td><%=a.getAlumno().getAlumnoId()%></td>
                            <td><%=a.getAlumno().getNombre() + " " + a.getAlumno().getApellido()%></td>
                            <td><%=a.getAlumno().getDni()%></td>
                            <td><%=a.getCurso().getNombre()%></td>
                            <td><%=a.getCurso().getDia()%></td>
                            <td><%=a.getCurso().getHorario()%></td>
                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvEliminarInscripcion" method="POST">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style="background-color:red; margin-right:5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=a.getInscripcionId()%>"> 
                                </form>
                                <form name="editar" action="SvEditarInscripcion" method="GET">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style=" margin-left:5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=a.getInscripcionId()%>">
                                </form>
                            </td>

                        </tr> 
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<div style="display:flex; justify-content: space-between; align-items: center; margin-left: 84%;">
    <button type="button" class="btn btn-secondary" id="volverBtn" style="width: 130px;">Volver</button>

</div>   
<script>
    document.getElementById("volverBtn").addEventListener("click", function(){
        window.history.back();
    });
</script>

<%@include file="components/bodypartefinal.jsp" %>

