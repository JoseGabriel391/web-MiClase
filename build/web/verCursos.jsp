<%@page import="logica.Curso"%>
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
                            <th>Curso</th>
                            <th style="width:210px">Accion</th>
                        </tr>
                    </thead>
                   
                    <%
                        List<Curso> lista = (List<Curso>) request.getSession().getAttribute("lista");
                    %>
                    <tbody>
                        <% for (Curso e : lista) {%>
                        <tr>
                            <td><%=e.getCursoId()%></td>
                            <td><%=e.getNombre()%></td>
                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvEliminarCurso" method="POST">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style="background-color:red; margin-right:5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=e.getCursoId()%>"> 
                                </form>
                                <form name="editar" action="SvEditarCurso" method="GET">
                                    <button type="submit" class="btn btn-primary byn-user btn-block" style=" margin-left:5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=e.getCursoId()%>">
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

