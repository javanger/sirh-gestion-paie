<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Creation employ&#xe9</title>
<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				// si l'ur est creer-collab.html?errors 
				if (window.location.search == "?errors") {
					form.classList.add('was-validated');
				}
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">LOG</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="flase" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/paie/mvc/employes/lister">Employ&#xe9s </a></li>
					<li class="nav-item"><a class="nav-link" href="./lister">Bulletins</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="row">
		<div class="col-3 offset-5 mt-5">
			<h2>Creer Bulletin de Salaire</h2>
		</div>
	</div>
	<div class="col-12 offset-2 mt-5">
		<form:form methode="post" modelAttribute="bulletinSalaire">
			<div class="form-group row">
				<label for="input-periode" class="col-sm-2 col-form-label">Période
					:</label>
				<div class="col-sm-4 ">
					<form:select path="periode.id" class="form-control"
						id="formPeriode">
						<form:options items="${periodes}" itemValue="id"
							itemLabel="debutFin" />
					</form:select>
					<div class="invalid-feedback">La période est obligatoire.</div>
				</div>
			</div>
			<div class="form-group row mt-5">
				<label for="input-matricule" class="col-sm-2 col-form-label">Matricule
					:</label>
				<div class="col-sm-4">
					<form:select path="remunerationEmploye.id" class="form-control"
						id="formMatricule">
						<form:options items="${remunerations}" itemValue="id"
							itemLabel="matricule" />
					</form:select>
					<div class="invalid-feedback">Le matricule est obligatoire.</div>
				</div>
			</div>
			<div class="form-group row mt-5">
				<label for="input-prime" class="col-sm-2 col-form-label">Prime
					Exceptionnelle :</label>
				<div class="col-sm-4">
					<form:input type="text" path="primeExceptionnelle"
						class="form-control" id="formPrime" placeholder="Prime" />
					<div class="invalid-feedback">La prime Exceptionnelle est
						obligatoire.</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-1 offset-5 ">
					<form action="accueil.php" method="GET">
						<button type="submit" class="btn btn-primary">Créer</button>
					</form>
				</div>
			</div>
		</form:form>
	</div>
</body>
<footer> </footer>
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