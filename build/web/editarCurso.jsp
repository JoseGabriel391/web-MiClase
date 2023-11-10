<%@page import="logica.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyprimeraparte.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="margin-top: -20px; margin-bottom: 35px; margin-left: 35%">Editar Curso</h1>
<%Curso a = (Curso)request.getSession().getAttribute("curEditar");%>
<form class="user" action="SvEditarCurso" method="POST" style="margin-left: 10%">
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
                <label for="descripcion" class="mx-2" style="padding-right: 30px;">Descripcion</label>
                <textarea type="text" class="form-control form-control-user mx-2" id="descripcion" name="descripcion"
                          style="width:400px" rows="4"><%=a.getDescripcion()%></textarea>
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="ubicacion" class="mx-2" style="padding-right: 30px;">Ubicacion</label>
                <input type="text" class="form-control form-control-user mx-2" id="ubicacion" name="ubicacion"
                   placeholder="ubicacion" style="width:400px" value="<%=a.getUbicacion()%>">
            </div>
            
        </div>
   
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="dias" class="mx-2" style="padding-right: 32px;">Dias</label>
                <input type="text" class="form-control form-control-user" id="dias" name="dias"
                       placeholder="Dias" style="width:400px" value="<%=a.getDia()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="horario" class="mx-2" style="padding-right: 30px;">Horario</label>
                <input type="text" class="form-control form-control-user" id="horario" name="horario"
                   placeholder="horario" style="width:400px" value="<%=a.getHorario()%>">
            </div>
            
        </div>
        <div class="col-sm-6 mb-3">
            <div class="form-group form-inline">
                <label for="cupo" class="mx-2" style="padding-right: 12px;">Cupo</label>
                <input type="text" class="form-control form-control-user" id="cupo" name="cupo"
                   placeholder="Cupo" style="width:400px" value="<%=a.getCupo()%>">
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
        Actualizar Curso
    </button>
    <hr>
   
</form>

<%@include file="components/bodypartefinal.jsp" %>
