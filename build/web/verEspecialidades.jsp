<%@page import="logica.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
    

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Especialidad</th>
                            <th style="width:210px">Accion</th>
                        </tr>
                    </thead>
                   
                    <%
                        List<Especialidad> lista = (List<Especialidad>) request.getSession().getAttribute("lista");
                    %>
                    <tbody>
                        <% for (Especialidad e : lista) {%>
                        <tr>
                            <td><%=e.getId()%></td>
                            <td><%=e.getDescripcion()%></td>
                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvEliminarEspecialidad" method="POST">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style="background-color:red; margin-right:5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=e.getId()%>"> 
                                </form>
                                <form name="editar" action="SvEditEspecialidad" method="GET">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style=" margin-left:5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=e.getId()%>">
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

