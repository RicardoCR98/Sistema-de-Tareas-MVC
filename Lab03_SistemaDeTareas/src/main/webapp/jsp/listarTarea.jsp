<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listarTarea.css" />
    <title>Listado de Tareas</title>
</head>

<body>
    <header class="container-header">
        <p class="container-header item-1">Gestor de Tareas</p>
        <p class="container-header item-2 btn1"><a href="index.html">Salir</a></p>
    </header>

    <main class="container">
        <div class="container-1">
            <h1>Listado de Tareas</h1>
            <c:if test="${not empty nombreUsuario}">
                <p>Bienvenido:<p style="color: ${nombreUsuario eq 'Luis' ? 'red' : 'Green'}"> ${nombreUsuario}</p></p>
            </c:if>
            <p><a href="InsertarTareaController">Nueva Tarea</a></p>
        </div>

        <div class="container-2">

	
		    <table class="table">
			    <thead>
			        <tr>
			            <th>Código</th>
			            <th>Nombre</th>
			            <th>Responsable</th>
			            <th>Estado</th>
			        </tr>
			    </thead>
			    <c:forEach items="${tareas}" var="tarea"  varStatus="status">
			        <tr>
			            <td>${tarea.codigo}</td>
			            <td>${tarea.nombre}</td>
			            <td>
			              <form action="AuxiliarController" method="POST">
                    			<select name="select-responsable-${tarea.codigo}" class="select" onchange="this.form.submit()" ${tarea.estado eq '2' ? 'disabled':''}>
								    <option class="option" value="0" ${tarea.responsable eq '0' ? 'selected' : ''}>Seleccione</option>
								    <option class="option" value="1" ${tarea.responsable eq '1' ? 'selected' : ''}>Pepe</option>
								    <option class="option" value="2" ${tarea.responsable eq '2' ? 'selected' : ''}>María</option>
								    <option class="option" value="3" ${tarea.responsable eq '3' ? 'selected' : ''}>Mariana</option>
								</select>
			                    <input type="hidden" name="codigo" value="${tarea.codigo}" />
			                    <input type="hidden" name="nombre" value="${tarea.nombre}" />
			                    <input type="hidden" name="estado-${tarea.codigo}" value="${tarea.estado}" />
                		</form>
			              
			            </td>
			            
					<c:choose>
					    <c:when test="${tarea.responsable != null && tarea.responsable ne '0'}">
					        <c:choose>
					            <c:when test="${tarea.estado eq '1'}">
					                <td class="por-asignar">Por hacer</td>
					            </c:when>
					            <c:when test="${tarea.estado eq '2'}">
					                <td class="completado">Completado</td>
					            </c:when>
					            <c:otherwise>
					                <td class="por-hacer">Por asignar</td>
					            </c:otherwise>
					        </c:choose>
					    </c:when>
					    <c:otherwise>
					        <td class="por-asignar">Por asignar</td>
					    </c:otherwise>
					</c:choose>

			        </tr>
			    </c:forEach>
			</table>
        </div>
    </main>
    
</body>
</html>
