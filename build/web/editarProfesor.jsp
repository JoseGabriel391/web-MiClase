<%@page import="logica.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Editar Profesor</h1>
<%Profesor a = (Profesor)request.getSession().getAttribute("proEditar");%>
<form class="user" action="SvEditarProfesor" method="POST" style="margin-left: 10%">
    <div class="form-row align-center">
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="nombre" class="mx-2" style="padding-right: 10px;">Nombre</label>
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" style="width:400px" value="<%=a.getNombre()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2" style="padding-right: 30px;">Apellido</label>
                <input type="text" class="form-control form-control-user mx-2" id="apellido" name="apellido"
                   placeholder="Apellido" style="width:400px" value="<%=a.getApellido()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2" style="padding-right: 30px;">DNI</label>
                <input type="text" class="form-control form-control-user mx-2" id="dni" name="dni"
                       placeholder="Dni" style="width:400px" value="<%=a.getDni()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2" style="padding-right: 20px;"> Fecha de<br> Nacimiento</label>
                <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac" style="width:400px" value="<%=a.getFechaNac()%>">
            </div>
            
        </div>
    </div>
    <div class="form-row align-center">
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="pais" class="mx-2" style="padding-right: 32px;">Pais</label>
                <input type="text" class="form-control form-control-user" id="pais" name="pais"
                   placeholder="Pais" style="width:400px" value="<%=a.getPais()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="provincia" class="mx-2" style="padding-right: 30px;">Provincia</label>
                <input type="text" class="form-control form-control-user" id="provincia" name="provincia"
                   placeholder="Provincia" style="width:400px" value="<%=a.getProvincia()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="ciudad" class="mx-2" style="padding-right: 12px;">Ciudad</label>
                <input type="text" class="form-control form-control-user" id="ciudad" name="ciudad"
                   placeholder="Ciudad" style="width:400px" value="<%=a.getCiudad()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="direccion" class="mx-2" style="padding-right: 30px;">Direccion</label>
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Dirección" style="width:400px" value="<%=a.getDireccion()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2" style="padding-right: -5px;">Telefono</label>
                <input type="text" class="form-control form-control-user mx-2" id="tel" name="telefono"
                   placeholder="Telefono" style="width:400px" value="<%=a.getTelefono()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="mail" class="mx-2" style="padding-right: 60px;">Mail</label>
                <input type="text" class="form-control form-control-user" id="mail" name="mail"
                       placeholder="Mail" style="width:400px" value="<%=a.getMail()%>">
            </div>
            
        </div>
        
    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Actualizar
    </button>
    <hr>
   
</form>


<%@include file="components/bodypartefinal.jsp" %>
