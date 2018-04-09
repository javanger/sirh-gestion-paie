<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">LOG</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="flase" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="./lister">Employ&#xe9s
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/paie/mvc/bulletins/lister">Bulletins</a></li>
			</ul>
		</div>
	</nav>
	<div class="row">
		<div class="col-4 offset-2">
			<h1>Connexion</h1>
		</div>
	</div>
	<!-- Spring Security s'attend aux paramètres "username" et "password" -->
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<form:form methode="post" modelAttribute="connnexion">
		<div class="form-group row">

			<label for="input-login" class="col-sm-2 col-form-label ">Login
				:</label>
			<div class="col-sm-4">
				<input type="text" id="formLogin" placeholder="Login"
					name="username" />
				<div class="invalid-feedback">Le login est obligatoire.</div>
			</div>

		</div>
		<div class="form-group row">
			<label for="input-login" class="col-sm-2 col-form-label">Mot
				de passe :</label>
			<div class="col-sm-4">
				<input type="text" id="formPassword" placeholder="Mot de passe"
					name="password" />
				<div class="invalid-feedback">Le mot de passe est obligatoire.</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-1 offset-3 ">
				<button type="submit" class="btn btn-primary">Se connecter</button>
			</div>
		</div>
	</form:form>
	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
	<c:if test="${param.error !=null}">Erreur d'authentification</c:if>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>


</html>