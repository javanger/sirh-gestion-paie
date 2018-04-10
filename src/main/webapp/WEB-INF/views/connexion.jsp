<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/materia/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-kpxyUW5uLgBOlhLqm8Hga/aWgf7FgZWLhphVqsMgaW0s+G6KF1RZpUb6ygQL3WUE"
	crossorigin="anonymous">

</head>
<body class="container">
<h1>Connexion</h1>
<!-- Spring Security s'attend aux paramètres "username" et "password" -->
<form method="post">
	<input name="username">
	<input name="password">
	<input type="submit" value="Se connecter">
	<sec:csrfInput/>
</form>
<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
<c:if test="${param.error !=null}">
Erreur d'authentification
</c:if>
</body>
</html>