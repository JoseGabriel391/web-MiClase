<%@page import="logica.Curso"%>
<%@page import="logica.Inscripcion"%>
<%@page import="java.util.List"%>
<%@page import="logica.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Editar Inscripcion</h1>

 <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800"></h1>
                    

                    <!-- Content Row -->
                    <div class="row">

                        <div class="col-xl-8 col-lg-7">

                            <!-- Bar Chart -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Datos</h6>
                                </div>
                                <div class="card-body">
                                    <div class="chart-bar">
                                        <canvas id="myBarChart"></canvas>
                                        <div style="margin-top:-138px">
                                            <!-- Topbar Search -->
                                            <%Inscripcion i = (Inscripcion)request.getSession().getAttribute("insEditar");%>
                                            <%Curso c = (Curso)request.getSession().getAttribute("cursoSeleccionado");%>
                                            <form class="user" action="SvEditarInscripcion" method="POST">
                                              
                                                <div class="form-group col">
                                                    <div class="col-sm-6 mb-3">
                                                        <label for="id">Legajo: </label>
                                                        <span id="id" name="id">
                                                            <%= (i != null) ? i.getAlumno().getAlumnoId() : ""%>
                                                        </span>
                                                    </div>
                                                        <input type="hidden" id="idIns" name="idIns" value="<%= (i != null) ? i.getInscripcionId() : ""%>">
                                                        <input type="hidden" id="alumnoId" name="alumnoId" value="<%= (i != null) ? i.getAlumno().getAlumnoId() : ""%>">
                                                    
                                                    <div class="col-sm-6 mb-3">
                                                        <label for="nombre">Nombre: </label>
                                                        <span id="nombre" name="nombre">
                                                            <%= (i != null) ? i.getAlumno().getNombre() + " " + i.getAlumno().getApellido(): ""%>
                                                        </span>
                                                    </div>
                                                    
                                                    <div class="col-sm-6 mb-3">
                                                        <label for="cboCurso">Curso:</label>
                                                        <br>
                                                        <select name="cboCurso" style="width:400px; color: #000" >

                                                            <c:forEach var="t" items="${listaCursos}">
                                                                <c:choose>
                                                                    <c:when test="${t.getCursoId() == cursoSeleccionado.getCursoId()}">
                                                                        <option value="${t.getCursoId()}" selected>${t.getNombre()}</option>
                                                                    </c:when>

                                                                    <c:otherwise>
                                                                        <option value="${t.getCursoId()}">${t.getNombre()}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>

                                                        <button class="btn btn-primary btn-user btn-block" type="submit">
                                                    Actualizar
                                                </button>
                                                <hr>

                                            </form>
                                        </div>
                                       
                                    </div>
                                    <hr>
                                </div>
                            </div>

                        </div>

                       
                    </div>

                </div>
                <!-- /.container-fluid -->
                
                <!-- Modal busqueda alumno -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="SvBuscarAlumno" method="POST">
                                    <div class="form-group">
                                        <label for="id" class="col-form-label">Legajo:</label>
                                        <input type="text" class="form-control" id="id" name="id">
                                    </div>
                                   <button type="submit" class="btn btn-primary" >Buscar</button>
                                </form>
                               
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                
                            </div>
                        </div>
                    </div>
                </div>
                <!--/ Fin Modal busqueda alumno -->
                <div style="display:flex; justify-content: space-between; align-items: center; margin-left: 84%;">
    <button type="button" class="btn btn-secondary" id="volverBtn" style="width: 130px;">Volver</button>

</div>   
<script>
    document.getElementById("volverBtn").addEventListener("click", function(){
        window.history.back();
    });
</script>
<%@include file="components/bodypartefinal.jsp" %>
<%
    if (request.getAttribute("error") != null) {%>
    <script type="text/javascript">
        alert("<%= request.getAttribute("error")%>");
    </script>
<%}%>

<script>
    function validar(){
        let legajo = document.getElementById("id").value;
        if(!legajo){
            alert("Debe ingresar el legajo");
            return false;
        }
        return true;
    }
</script>

<script>
    document.getElementById("enviar").addEventListener("click", function(){
        var id = document.getElementById("id").textContent;
        
        $.ajax({
            url: "SvAltaInscripcion",
            method: "POST",
            data: {id: id},
            success: function(response){
                
            }
        });
    });
</script>