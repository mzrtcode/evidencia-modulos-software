<%@ page import="ModelosDao.EmpleadoImp" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelos.Ruta" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Modelos.Empleado" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
    <h1 class="mt-4">Empleados 🤵🏻</h1>
    <a href="ControladorEmpleados?accion=add" class="btn btn-primary mt-4">Agregar nuevo</a>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Nombres</th>
            <th class="text-center">Apellidos</th>
            <th class="text-center">correo</th>
            <th class="text-center">celular</th>
            <th class="text-center">Fecha Nacimiento</th>
            <th class="text-center">direccion</th>
            <th class="text-center">acciones</th>

        </tr>
        </thead>
        <%
            EmpleadoImp empleadoImp = new EmpleadoImp();
            List<Empleado> lista =  empleadoImp.listar();
            Iterator<Empleado> iterator = lista.iterator();
            Empleado empleado = null;
            while(iterator.hasNext()){
                empleado = iterator.next();

        %>
        <tbody>
        <tr>
            <td class="text-center"><%= empleado.getId()%></td>
            <td class="text-center"><%= empleado.getNombres()%></td>
            <td class="text-center"><%= empleado.getApellidos()%></td>
            <td class="text-center"><%= empleado.getCorreo()%></td>
            <td class="text-center"><%= empleado.getCelular()%></td>
            <td class="text-center"><%= empleado.getFecha_nacimiento()%></td>
            <td class="text-center"><%= empleado.getDireccion()%></td>

            <td class="text-center">
                <a href="ControladorEmpleados?accion=editar&id=<%= empleado.getId()%>" ><i class='bx bx-edit'></i></a>
                <a href="ControladorEmpleados?accion=eliminar&id=<%= empleado.getId()%>" ><i class='bx bx-trash' ></i></a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>

</div>
</body>
</html>