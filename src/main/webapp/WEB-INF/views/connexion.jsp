<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Paie - App</title>
		
		<!--  <link rel="stylesheet" href='<c:url value="/bootstrap-3.3.7/css/bootstrap.min.css"></c:url>'>-->
		<link href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-QAdi7HQouHzrMcg66qFdsKV2BCFW/iVhCRvooAkqS4d5rXV8Hlu+X8MY3ao03fgn" crossorigin="anonymous">
		
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
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>