<%@page import="logica.Curso"%>
<%@page import="logica.Nota"%>
<%@page import="logica.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <h1 style="margin-top: -20px; margin-bottom: 35px; margin-left: 35%">Editar Notas</h1>
    <%Nota a = (Nota)request.getSession().getAttribute("notasEditar");%>
    <%Curso c = (Curso)request.getSession().getAttribute("cursoSeleccionado");%>
    <form class="user" action="SvEditarNotas" method="POST" style="margin-left: 10%" onsubmit="return validar();">
        <div class="form-row align-center">
            <div class="col-sm-6 mb-3">
                <div class="form-group form-inline">
                    <label for="descripcion" class="mx-2" style="padding-right: 10px;">Descripcion: </label>
                    <input type="text" class="form-control form-control-user" id="descripcion" name="descripcion"
                           placeholder="descripcion" style="width:400px" value="<%= a.getDescripcion()%>">
                </div>
            </div>
            <div class="col-sm-6 mb-3">
                <div class="form-group form-inline">
                    <label for="nota" class="mx-2" style="padding-right: 30px;">Nota: </label>
                    <input type="text" class="form-control form-control-user mx-2" id="nota" name="nota"
                       placeholder="Nota" style="width:400px" value="<%= a.getNota()%>">
                </div>
            </div>
            <div class="col-sm-6 mb-3">
                <div class="form-group form-inline">
                    <label for="cboCurso" style="padding-right: 40px;">Curso: </label>
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

        </div>


        </div>

        <button class="btn btn-primary btn-user btn-block" type="submit" style="width: 30%; margin-left: 35%;">
            Cargar Nota
        </button>
        <hr>

    </form>
</body>
<div style="display:flex; justify-content: space-between; align-items: center; margin-left: 84%;">
    <button type="button" class="btn btn-secondary" id="volverBtn" style="width: 130px;">Volver</button>

</div>   
<script>
    document.getElementById("volverBtn").addEventListener("click", function(){
        window.history.back();
    });
</script>
<script>
    function validar(){
        let nota = document.getElementById("nota").value;
        if(!nota){
            alert("Debe ingresar la nota");
            return false;
        }
        
        let descripcion = document.getElementById("descripcion").value;
        if(!descripcion){
            alert("Debe ingresar la descripcion");
            return false;
        }
        return true;
    }
</script>
<%@include file="components/bodypartefinal.jsp" %>
