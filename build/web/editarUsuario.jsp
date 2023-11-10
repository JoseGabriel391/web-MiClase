<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Editar Usuarios</h1>

<%Usuario usu = (Usuario)request.getSession().getAttribute("usuEditar");%>
<form class="user" action="SvEditUsuario" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre Usuario" value="<%=usu.getUsuario()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña" value="<%=usu.getContrasenia()%>">
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
        Guardar Modificación
    </button>
    <hr>
   
</form>

<%@include file="components/bodypartefinal.jsp" %>
