<%@page import="logica.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Editar Administrador</h1>
<%Administrador a = (Administrador)request.getSession().getAttribute("admEditar");%>
<form class="user" action="SvEditarAdmin" method="POST">
    <div class="form-row align-center">
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="nombre" class="mx-2">Nombre</label>
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" value="<%=a.getNombre()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2">Apellido</label>
                <input type="text" class="form-control form-control-user mx-2" id="apellido" name="apellido"
                   placeholder="Apellido" value="<%=a.getApellido()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2">DNI</label>
                <input type="text" class="form-control form-control-user mx-2" id="dni" name="dni"
                       placeholder="Dni" value="<%=a.getDni()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2">Fecha de Nacimiento</label>
                <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac" value="<%=a.getFechaNac()%>">
            </div>
            
        </div>
    </div>
    <div class="form-row align-center">
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="pais" class="mx-2">Pais</label>
                <input type="text" class="form-control form-control-user" id="pais" name="pais"
                   placeholder="Pais" value="<%=a.getPais()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="provincia" class="mx-2">Provincia</label>
                <input type="text" class="form-control form-control-user" id="provincia" name="provincia"
                   placeholder="Provincia" value="<%=a.getProvincia()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="ciudad" class="mx-2">Ciudad</label>
                <input type="text" class="form-control form-control-user" id="ciudad" name="ciudad"
                   placeholder="Ciudad" value="<%=a.getCiudad()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="direccion" class="mx-2">Direccion</label>
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Dirección" value="<%=a.getDireccion()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="fechaNac" class="mx-2">Telefono</label>
                <input type="text" class="form-control form-control-user mx-2" id="tel" name="telefono"
                   placeholder="Telefono" value="<%=a.getTelefono()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="mail" class="mx-2">Mail</label>
                <input type="text" class="form-control form-control-user" id="mail" name="mail"
                   placeholder="Mail" value="<%=a.getMail()%>">
            </div>
            
        </div>
     
        
    </div>
        
    </div>
   
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Actualizar
    </button>
    <hr>
   
</form>


<%@include file="components/bodypartefinal.jsp" %>
