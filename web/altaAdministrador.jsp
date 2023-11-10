<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Registrar Administrador</h1>

<form class="user" action="SvAltaAdmin" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="apellido">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni" name="dni"
                   placeholder="Dni">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Direccion">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="ciudad" name="ciudad"
                   placeholder="Ciudad">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                   placeholder="Telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="mail" name="mail"
                   placeholder="Mail">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre Usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="cboRol">Rol:</label>
            <br>
            <select name="cboRol">
                <c:forEach var="t" items="${listaRoles}">
                    <option value="${t.getId()}">${t.getRol()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Usuario
    </button>
    <hr>
   
</form>
<div>
    Roles cargados:
    <ul>
        <c:forEach var="rol" items="${listaRoles}">
            <li>${rol.rol}</li>
        </c:forEach>
    </ul>
</div>

<%@include file="components/bodypartefinal.jsp" %>
