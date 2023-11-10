<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="margin-top: -20px; margin-bottom: 35px; margin-left: 35%">Alta Curso</h1>

<form class="user" action="SvAltaCurso" method="POST" style="margin-left: 10%">
    <div class="form-row align-center">
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="nombre" class="mx-2" style="padding-right: 10px;">Nombre</label>
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="descripcion" class="mx-2" style="padding-right: 30px;">Descripcion</label>
                <textarea type="text" class="form-control form-control-user mx-2" id="descripcion" name="descripcion"
                          placeholder="Descripcion" style="width:400px" rows="4"></textarea>
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="ubicacion" class="mx-2" style="padding-right: 30px;">Ubicacion</label>
                <input type="text" class="form-control form-control-user mx-2" id="ubicacion" name="ubicacion"
                   placeholder="ubicacion" style="width:400px">
            </div>
            
        </div>
   
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="dias" class="mx-2" style="padding-right: 32px;">Dias</label>
                <input type="text" class="form-control form-control-user" id="dias" name="dias"
                   placeholder="Dias" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="horario" class="mx-2" style="padding-right: 30px;">Horario</label>
                <input type="text" class="form-control form-control-user" id="horario" name="horario"
                   placeholder="horario" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="cupo" class="mx-2" style="padding-right: 12px;">Cupo</label>
                <input type="text" class="form-control form-control-user" id="cupo" name="cupo"
                   placeholder="Cupo" style="width:400px">
            </div>
            
        </div>
        
       
            <div class="form-group form-inline">
                <label for="cboEspecialidad" style="padding-right: 40px;">Especialidad:</label>
                <br>
                <select name="cboEspecialidad" style="width:400px; color: #000" >
                    <c:forEach var="t" items="${listaEspecialidad}">
                        <option value="${t.getId()}">${t.getDescripcion()}</option>
                    </c:forEach>
                </select>
            </div>
            
        </div>
    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit" style="width: 30%; margin-left: 35%;">
        Registrar Curso
    </button>
    <hr>
   
</form>
<div style="display:flex; justify-content: space-between; align-items: center; margin-left: 84%;">
    <button type="button" class="btn btn-secondary" id="volverBtn" style="width: 130px;">Volver</button>

</div>   
<script>
    document.getElementById("volverBtn").addEventListener("click", function(){
        window.history.back();
    });
</script>

<%@include file="components/bodypartefinal.jsp" %>
