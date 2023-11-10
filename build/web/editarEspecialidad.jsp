<%@page import="logica.Especialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>

<h1>Editar Especialidad</h1>

<%Especialidad es = (Especialidad)request.getSession().getAttribute("esEditar");%>
<form class="user" action="SvEditEspecialidad" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad" name="especialidad"
                   placeholder="Especialidad" value="<%=es.getDescripcion()%>">
        </div>
        

    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Modificación
    </button>
    <hr>
   
</form>

<%@include file="components/bodypartefinal.jsp" %>
