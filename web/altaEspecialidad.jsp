<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>

<h1>Alta Usuarios</h1>

<form class="user" action="SvEspecialidad" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad" name="especialidad"
                   placeholder="Especialidad">
        </div>
    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Especialidad
    </button>
    <hr>
   
</form>

<%@include file="components/bodypartefinal.jsp" %>
