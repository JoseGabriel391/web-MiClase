<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="margin-top: -20px; margin-bottom: 35px; margin-left: 35%">Alta Alumno</h1>

<form class="user" action="SvAltaAlumno" method="POST" style="margin-left: 10%">
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
                <label for="fechaNac" class="mx-2" style="padding-right: 30px;">Apellido</label>
                <input type="text" class="form-control form-control-user mx-2" id="apellido" name="apellido"
                   placeholder="Apellido" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="dni" class="mx-2" style="padding-right: 30px;">DNI</label>
                <input type="text" class="form-control form-control-user mx-2" id="dni" name="dni"
                   placeholder="Dni" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2" style="padding-right: 20px;"> Fecha de<br> Nacimiento</label>
                <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac" style="width:400px">
            </div>
            
        </div>
    </div>
    <div class="form-row align-center">
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="pais" class="mx-2" style="padding-right: 32px;">Pais</label>
                <input type="text" class="form-control form-control-user" id="pais" name="pais"
                   placeholder="Pais" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="provincia" class="mx-2" style="padding-right: 30px;">Provincia</label>
                <input type="text" class="form-control form-control-user" id="provincia" name="provincia"
                   placeholder="Provincia" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="ciudad" class="mx-2" style="padding-right: 12px;">Ciudad</label>
                <input type="text" class="form-control form-control-user" id="ciudad" name="ciudad"
                   placeholder="Ciudad" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="direccion" class="mx-2" style="padding-right: 30px;">Direccion</label>
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Dirección" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2" style="padding-right: -5px;">Telefono</label>
                <input type="text" class="form-control form-control-user mx-2" id="tel" name="telefono"
                   placeholder="Telefono" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="mail" class="mx-2" style="padding-right: 60px;">Mail</label>
                <input type="text" class="form-control form-control-user" id="mail" name="mail"
                   placeholder="Mail" style="width:400px">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
               <label for="nombreUsu" class="mx-2" style="padding-right: 30px;">User</label>
                <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre Usuario" style="width:400px"> 
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="contrasenia" class="mx-2" style="padding-right: 30px;">Password</label>
                <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña" style="width:400px">
            </div>
            
        </div>
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="cboRol" style="padding-right: 40px;">Rol:</label>
                <br>
                <select name="cboRol" style="width:400px; color: #000" >
                    <c:forEach var="t" items="${listaRoles}">
                        <c:if test="${t.getId() == 3}">
                            <option value="${t.getId()}">${t.getRol()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            
        </div>
    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit" style="width: 30%; margin-left: 35%;">
        Registrar alumno
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
