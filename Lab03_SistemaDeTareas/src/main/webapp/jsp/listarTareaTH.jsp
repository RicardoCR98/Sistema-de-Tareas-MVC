<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listarTareaTH.css" />
    <title>Listar Tarea TH</title>
</head>

<body>
    <header class="container-header">
        <p class="container-header item-1">Gestor de Tareas</p>
        <p class="container-header item-2 btn1"><a href="CerrarSesionController">Cerrar Sesión</a></p>
    </header>

    <main class="container">
        <div class="container-1">
            <h1>Listado de Tareas para: <c:if test="${not empty nombreUsuario}"><p style="color:#008f39; display:inline-block;"> ${nombreUsuario}</p></c:if></h1>
        </div>

        <div class="container-2">

            <table class="table">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>¿Hecho?</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <form action="AuxiliarTHController" method="POST">
	                <c:forEach items="${tareasUnitarias}" var="tarea" varStatus="status">
				        <tr>
				            <td>${tarea.codigo}</td>
				            <td>${tarea.nombre}</td>
				            <td>
								<input name="cbox-hecho-${tarea.codigo}" type="checkbox" id="cbox-${tarea.codigo}" value="1" ${tarea.estado eq '2' ? 'checked' : ''}  onchange="this.form.submit()">
								<label for="cbox-${tarea.codigo}"></label>
	                        </td>
				            <c:choose>
			                <c:when test="${tarea.estado != null && tarea.estado ne '2'}">
			                    <td class="por-hacer" <c:if test="${tarea.estado eq '1'}"></c:if>>Por hacer</td>
			                </c:when>
			                <c:otherwise>
			                    <td class="completado" <c:if test="${tarea.estado eq '2'}"></c:if>>Completado</td>
			                </c:otherwise>
			            </c:choose>
				        </tr>
				    </c:forEach>
                </form>
            </table>
        </div>
    </main>
</body>

=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listarTareaTH.css" />
    <title>Document</title>
</head>

<body>
    <header class="container-header">
        <p class="container-header item-1">Gestor de Tareas</p>
        <p class="container-header item-2 btn1"><a href="CerrarSesionController">Cerrar Sesión</a></p>
    </header>

    <main class="container">
        <div class="container-1">
            <h1>Listado de Tareas para: <c:if test="${not empty nombreUsuario}"><p style="color:#008f39; display:inline-block;"> ${nombreUsuario}</p></c:if></h1>
        </div>

        <div class="container-2">

            <table class="table">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>¿Hecho?</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <form action="AuxiliarTHController" method="POST">
	                <c:forEach items="${tareasUnitarias}" var="tarea" varStatus="status">
				        <tr>
				            <td>${tarea.codigo}</td>
				            <td>${tarea.nombre}</td>
				            <td>
								<input name="cbox-hecho-${tarea.codigo}" type="checkbox" id="cbox-${tarea.codigo}" value="1" ${tarea.estado eq '2' ? 'checked' : ''}  onchange="this.form.submit()">
								<label for="cbox-${tarea.codigo}"></label>
	                        </td>
				            <c:choose>
			                <c:when test="${tarea.estado != null && tarea.estado ne '2'}">
			                    <td class="por-hacer" <c:if test="${tarea.estado eq '1'}"></c:if>>Por hacer</td>
			                </c:when>
			                <c:otherwise>
			                    <td class="completado" <c:if test="${tarea.estado eq '2'}"></c:if>>Completado</td>
			                </c:otherwise>
			            </c:choose>
				        </tr>
				    </c:forEach>
                </form>
            </table>
        </div>
    </main>
</body>

>>>>>>> branch 'main' of https://github.com/RicardoCR98/Sistema-de-Tareas-MVC.git
</html>