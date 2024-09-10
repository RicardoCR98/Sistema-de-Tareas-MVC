<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body class="container-1">
    <div class="container-11">
        <h1>SISTEMA DE TAREAS MVC</h1>
    </div>
    <div class="container-2">
        <form action="../LoginController" method="POST" class="form">
            <fieldset>
                <legend>Login</legend>
                <p>Username</p>
                <input type="text" name="user" class="input" required/>
                <p>Contraseña</p>
                <input type="password" name="password" class="input" required/> 
                <br>
                <br>
                <input type="submit" value="Ingresar" class="button"/>
            </fieldset>
        </form>
    </div>

    <footer class="container-3">
        <p>Integrantes:</p>
            <p>Lisbeth Dayana Romo Gavilanes</p>
            <p>Jhoaho Gabriel Sánchez Cabrera</p>
            <p>Roberto Ricardo Sosa Salazar</p>
            <p>Gary Ricardo Campana Ramírez </p>    
    </footer>
</body>
</html>