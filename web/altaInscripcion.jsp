<%@page import="java.util.List"%>
<%@page import="logica.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Inscripcion</h1>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>
 <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Charts</h1>
                    

                    <!-- Content Row -->
                    <div class="row">

                        <div class="col-xl-8 col-lg-7">

                            <!-- Bar Chart -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Bar Chart</h6>
                                </div>
                                <div class="card-body">
                                    <div class="chart-bar">
                                        <canvas id="myBarChart"></canvas>
                                        <div style="margin-top:-138px">
                                            <!-- Topbar Search -->
                                            <form
                                                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" 
                                                action="SvBuscarAlumno" method="POST" onsubmit="return validar();">
                                                <div class="input-group">
                                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Ingresar legajo"
                                                           aria-label="Search" aria-describedby="basic-addon2" name="id" id="id">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="submit">
                                                            <i class="fas fa-search fa-sm"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                            <br>
                                            <hr>
                                            <br>
                                            <form class="user" action="SvAltaInscripcion" method="POST" id="miFormulario">
                                                <% 
                                                    Alumno a = (Alumno)request.getSession().getAttribute("alumnoEncontrado");
                                                %>
                                                <div class="form-group col">
                                                    <div class="col-sm-6 mb-3">
                                                        <label for="id">Legajo: </label>
                                                        <span id="id" name="id">
                                                            <%= (a != null) ? a.getAlumnoId() : ""%>
                                                        </span>
                                                    </div>
                                                        
                                                        <input type="hidden" id="alumnoId" name="alumnoId" value="<%= (a != null) ? a.getAlumnoId() : ""%>">
                                                    
                                                    <div class="col-sm-6 mb-3">
                                                        <label for="nombre">Nombre: </label>
                                                        <span id="nombre" name="nombre">
                                                            <%= (a != null) ? a.getNombre() + " " + a.getApellido(): ""%>
                                                        </span>
                                                    </div>
                                                        
                                                     <div class="col-sm-6 mb-3">
                                                        <label for="dni">Dni: </label>
                                                        <span id="dni" name="dni">
                                                            <%= (a != null) ? a.getDni() : ""%>
                                                        </span>
                                                    </div>
                                                    
                                                    <div class="col-sm-6 mb-3">
                                                        <label for="cboCurso">Curso:</label>
                                                        <br>
                                                        <select name="cboCurso">
                                                            <c:forEach var="t" items="${listaCursos}">
                                                                <option value="${t.getCursoId()}">${t.getNombre()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>

                                                        <button class="btn btn-primary btn-user btn-block" type="submit">
                                                    Inscribir
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

<script>
    document.addEventListener('DOMContentLoaded', function(){
        var formulario = document.getElementById('miFormulario');
        formulario.reset();
    }) 
</script>