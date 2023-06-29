<%@ page import="ModelosDao.RutaImp" %>
<%@ page import="Modelos.Ruta" %>
<%@ page import="ModelosDao.AgenciaImp" %>
<%@ page import="Modelos.Agencia" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>CRUD APP SENA</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">CRUD-APP</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/GA7-220501096-AA2-EV02/ControladorRutas?accion=listar">Rutas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/GA7-220501096-AA2-EV02/ControladorEmpleados?accion=listar">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/GA7-220501096-AA2-EV02/ControladorAgencias?accion=listar">Agencias</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
   <div class="container">
       <div class="col-lg-6">
           <%
               AgenciaImp agenciaImp = new AgenciaImp();
               int id = Integer.parseInt((String)request.getAttribute("idAgencia"));
               Agencia agencia = (Agencia) agenciaImp.obtenerPorId(id);

           %>
           <h1 class="mt-4">Editar agencia</h1>
           <form action="ControladorAgencias" id="formulario">
               Nombre
               <br>
               <input class="form-control" type="text" name="txtInicio" value="<%=agencia.getNombre()%>">
               Codigo Interno
               <br>
               <input class="form-control"  type="text" name="txtDestino" value="<%=agencia.getCodigo_interno()%>">
               <br>
                Direccion
               <br>
               <input class="form-control"  type="text" name="txtDestino" value="<%=agencia.getDireccion()%>">
               Estado
               <br>
               <div class="form-check form-switch d-flex justify-content-start">
                   <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheck" <% if (agencia.isEstado()) { %>checked<% } %>>
               </div>

               <input type="hidden" name="txtId" value="<%=agencia.getId()%>">
               <br>
               <button class="btn btn-primary" type="submit" name="accion" value="Actualizar">Actualizar</button>
               <a href="ControladorAgencias?accion=listar"  class="btn btn-secondary">Regresar</a>

           </form>


       </div>
   </div>

    </body>
</html>
