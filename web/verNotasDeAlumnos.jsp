<%@page import="logica.Alumno"%>
<%@page import="logica.Nota"%>
<%@page import="logica.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<% int alumnoId = 0;%>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
    

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Notas</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Legajo</th>
                            <th>Alumno</th>
                            <th>Curso</th>
                            <th>Descripcion</th>
                            <th>Nota</th>
                            <th style="width:210px">Accion</th>
                        </tr>
                    </thead>
                   
                    <%
                        List<Nota> lista = (List<Nota>) request.getSession().getAttribute("lista");
                    %>
                    <tbody>
                        <% for (Nota e : lista) {%>
                        <%alumnoId = e.getAlumno().getAlumnoId();%>
                        <tr>
                            <td><%=e.getNotaId()%></td>
                            <td><%=e.getAlumno().getNombre() + " " + e.getAlumno().getApellido()%></td>
                            <td><%=e.getCurso().getNombre()%></td>
                            <td><%=e.getDescripcion()%></td>
                            <td><%=e.getNota()%></td>
                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvEliminarNota" method="POST">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style="background-color:red; margin-right:5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=e.getNotaId()%>"> 
                                </form>
                                <form name="editar" action="SvEditarNotas" method="GET">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style=" margin-left:5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=e.getNotaId()%>">
                                </form>
                            </td>

                        </tr> 
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
     <%  
            
               Alumno a = (Alumno) request.getSession().getAttribute("alumno");
            
         %>
    <div style="display:flex; justify-content: space-between; align-items: center; margin-left: 84%;">
        <button type="button" class="btn btn-secondary" id="volverBtn" style="width: 130px;">Volver</button>
        <form name="agregar" action="SvAltaNota" method="GET">
            <button type="submit" class="btn btn-success" >
                Agregar Nota
            </button>
            <input type="hidden" name="id" value="<%=a.getAlumnoId()%>">
        </form>
    </div>                
     
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<script>
    document.getElementById("volverBtn").addEventListener("click", function(){
        window.history.back();
    });
</script>

<%@include file="components/bodypartefinal.jsp" %>

