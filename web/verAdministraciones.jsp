<%@page import="logica.Administrador"%>
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
            <h6 class="m-0 font-weight-bold text-primary">Administradores</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>fecha nac.</th>
                            <th>Pais</th>
                            <th>Provincia</th>
                            <th>Ciudad</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th>mail</th>
                            <th style="width:210px">Accion</th>
                        </tr>
                    </thead>
                    <%
                        List<Administrador> listaAdmin = (List<Administrador>) request.getSession().getAttribute("listaAdmins");
                    %>
                    <tbody>
                        <% for (Administrador a : listaAdmin) {%>
                        <tr>
                            <td><%=a.getAdministradorId()%></td>
                            <td><%=a.getNombre()%></td>
                            <td><%=a.getApellido()%></td>
                            <td><%=a.getDni()%></td>
                            <td><%=a.getFechaNac()%></td>
                            <td><%=a.getPais()%></td>
                            <td><%=a.getProvincia()%></td>
                            <td><%=a.getCiudad()%></td>
                            <td><%=a.getDireccion()%></td>
                            <td><%=a.getTelefono()%></td>
                            <td><%=a.getMail()%></td>
                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvEliminarAdmin" method="POST">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style="background-color:red; margin-right:5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=a.getAdministradorId()%>"> 
                                </form>
                                <form name="editar" action="SvEditarAdmin" method="GET">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style=" margin-left:5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=a.getAdministradorId()%>">
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

