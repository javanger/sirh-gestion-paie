<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

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

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Log</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item"><a class="nav-link" href="/paie/">Index
				</a></li>

				<li class="nav-item"><a class="nav-link"
					href="/paie/bulletins/lister">Bulletin </a></li>

				<li class="nav-item"><a class="nav-link"
					href="/paie/employes/lister">Employé</a></li>

			</ul>

		</div>
	</nav>

	<div class="container-fluid">


		<!-- Spring Security s'attend aux paramètres "username" et "password" -->
		<form method="post" class="needs-validation mt-4"
			novalidate="novalidate">
			<div class="form-row justify-content-center">
				<h1>Connexion</h1>
			</div>

			<div class="form-row justify-content-center">
				<div class="form-group col-10 col-sm-8 col-md-6 col-lg-4 mb-3">
					<label for="username">Username</label> <input class="form-control"
						placeholder="Username" name="username" required="required" />
					<div class="invalid-feedback">Veuillez saisir un username
						correct.</div>
				</div>
			</div>
			<div class="form-row justify-content-center">
				<div class="form-group col-10 col-sm-8 col-md-6 col-lg-4 mb-3">
					<label for="password">Password</label> <input class="form-control"
						placeholder="Password" name="password" required="required" />
					<div class="invalid-feedback">Veuillez saisir un password
						correct.</div>
				</div>
			</div>
			<div class="form-row justify-content-center">
				<div class="form-group col-10 col-sm-8 col-md-6 col-lg-4 mb-3">
					<input type="submit" class="form-control" value="Se connecter" />
				</div>
			</div>

			<sec:csrfInput />
			<div class="form-row justify-content-center">
				<c:if test="${param.error !=null}">Erreur d'authentification
			</c:if>
			</div>
		</form>

	</div>

	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->

</body>
</html>