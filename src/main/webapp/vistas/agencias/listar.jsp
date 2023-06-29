<%@ page import="ModelosDao.RutaImp" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelos.Ruta" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ModelosDao.AgenciaImp" %>
<%@ page import="Modelos.Agencia" %>
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
    <h1 class="mt-4">Agencias 🏦</h1>
    <a href="ControladorAgencias?accion=add" class="btn btn-primary mt-4">Agregar nuevo</a>
    <table class="table table-bordered mt-4">
        <thead>
        <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Nombre</th>
            <th class="text-center">Codigo Interno</th>
            <th class="text-center">Direccion</th>
            <th class="text-center">Estado</th>
            <th class="text-center">ACCIONES</th>
        </tr>
        </thead>
        <%
            AgenciaImp agenciaImp = new AgenciaImp();
            List<Agencia> lista =  agenciaImp.listar();
            Iterator<Agencia> iterator = lista.iterator();
            Agencia agencia = null;
            while(iterator.hasNext()){
                agencia = iterator.next();

        %>
        <tbody>
        <tr>
            <td class="text-center"><%= agencia.getId()%></td>
            <td class="text-center"><%= agencia.getNombre()%></td>
            <td class="text-center"><%= agencia.getCodigo_interno()%></td>
            <td class="text-center"><%= agencia.getDireccion()%></td>
            <td class="text-center">
                <% if (agencia.isEstado()) { %>
                <div class="form-check form-switch d-flex justify-content-center">
                    <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
                </div>
                <% } else { %>
                <div class="form-check form-switch d-flex justify-content-center">
                    <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault">
                </div>
                <% } %>
            </td>
            <td class="text-center">
                <a href="ControladorAgencias?accion=editar&id=<%= agencia.getId()%>" ><i class='bx bx-edit'></i></a>
                <a href="ControladorAgencias?accion=eliminar&id=<%= agencia.getId()%>" ><i class='bx bx-trash' ></i></a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>

</div>
</body>
</html>