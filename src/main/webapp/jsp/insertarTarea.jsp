<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/insertarTarea.css" />
    <title>Document</title>
</head>

<body>
    <header class="container-header">
        <h1 class="item-1">Nueva Tarea</h1>
        <p class="container-header item-2 btn1"><a href="ListarTareaController">Volver</a></p>
    </header>

    <main class="container">

        <form method="POST" action="InsertarTareaController" class="form">
			<label for="codigo" >Código</label> <br>
			<input type="text" name="codigo" id="codigo" class="input" size="40" value="${cod}" disabled style="color:#fff; text-align:center;"/><br>
			
			<label for="nombre">Nombre de la Tarea</label> <br>
			<input type="text" name="nombre" id="nombre"class="input" size="40" /> <br>
			
            <br><br> 
			<input type="submit" value="insertar" class="button"> 
		</form>
    </main>
</body>

</html>