<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Paie</title>		
		<link href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-GxhP7S92hzaDyDJqbdpcHqV5cFflxAx0Yze/X7vUONp43KK1E8eUWaJIMkit3D0R" crossorigin="anonymous">
	</head>
	<body class="container-fluid">
	
	<div class="row justify-content-center p-2 mt-5">
		<header>
			<h1>Connexion</h1>
		</header>
	</div>
			
	<div class="row mt-5">
		<div class="col"></div>		
		<div class="col">
			<!-- Spring Security s'attend aux param�tres "username" et "password" -->
			<form method="post">
			  	<div class="form-group">
					<input class="form-group" name="username">
				</div>
				<div class="form-group">
					<input type="password" class="form-group" name="password">
				</div>
				<div class="form-group" align="center">
					<input class="btn btn-primary" type="submit" value="Se connecter">
				</div>
				<sec:csrfInput/>
			</form>
			<!-- en cas d'erreur un param�tre "error" est cr�� par Spring Security -->
			<c:if test="${param.error !=null}">
				Erreur d'authentification
			</c:if>
		</div>
		<div class="col"></div>
	</div>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>