<%@ page import="ModelosDao.RutaImp" %>
<%@ page import="Modelos.Ruta" %>
<%@ page import="ModelosDao.EmpleadoImp" %>
<%@ page import="Modelos.Empleado" %>
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
                        <a class="nav-link active" href="/GA7-220501096-AA2-EV02/ControladorEmpleados?accion=listar">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/GA7-220501096-AA2-EV02/ControladorAgencias?accion=listar">Agencias</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
   <div class="container">
       <div class="col-lg-6">
           <%
               EmpleadoImp empleadoImp = new EmpleadoImp();
               int id = Integer.parseInt((String)request.getAttribute("idEmpleado"));
               Empleado empleado = (Empleado) empleadoImp.obtenerPorId(id);

           %>
           <h1 class="mt-4">Editar Empleado</h1>
           <form action="ControladorEmpleados">
               Nombres
               <br>
               <input class="form-control" type="text" name="txtNombres" value="<%=empleado.getNombres()%>">
               Apellidos
               <br>
               <input class="form-control"  type="text" name="txtApellidos" value="<%=empleado.getApellidos()%>">
               Correo
               <br>
               <input class="form-control"  type="text" name="txtCorreo" value="<%=empleado.getCorreo()%>">
               Celular
               <br>
               <input class="form-control"  type="text" name="txtCelular" value="<%=empleado.getCelular()%>">
               Fecha Nacimiento:
               <br>
               <input class="form-control"  type="text" name="txtFechaNacimiento" value="<%=empleado.getFecha_nacimiento()%>">
               Direccion
               <br>
               <input class="form-control"  type="text" name="txtDireccion" value="<%=empleado.getDireccion()%>">
               <input type="hidden" name="txtId" value="<%=empleado.getId()%>">
               <br>
               <button class="btn btn-primary" type="submit" name="accion" value="Actualizar">Actualizar</button>
               <a href="ControladorEmpleados?accion=listar"  class="btn btn-secondary">Regresar</a>

           </form>
       </div>
   </div>
    </body>
</html>
