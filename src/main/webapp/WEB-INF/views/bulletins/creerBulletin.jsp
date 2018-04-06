<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>CreerBulletin</title>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="../employes/lister">Employes <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../bulletins/lister">Bulletins</a></li>


				</ul>
			</div>
		</nav>
	</header>
	<section>
		<h1>Creer le bulletin de salaire</h1>
		<div class="container">
			<form:form method="POST" modelAttribute="bulletinSalaire">


				<div class="form-group row">
					<label class="col-md-6 col-form-label">Periode</label>
					<div class="col-md-6">

						<form:select items="${periodes}" path="periode.id"
							class="form-control" />


					</div>
				</div>

				<div class="form-group row">
					<label for="profil" class="col-md-6 col-form-label">Matricule</label>
					<div class="col-md-6">

						<form:select class="form-control" path="remunerationEmploye.id"
							items="${employes}" itemLabel="matricule" itemValue="id"></form:select>



					</div>
				</div>

				<div class="form-group row ">
					<form:label path="primeExceptionnelle"
						class="col-md-6 col-form-label">Prime exceptionnelle</form:label>
					<div class="col-md-6">
						<form:input path="primeExceptionnelle" class="form-control" />
						<div class="invalid-feedback">Entrer le nom.</div>
					</div>

				</div>






				<div class="row justify-content-end">
					<button class="btn btn-primary" type="submit">Créer</button>
				</div>

			</form:form>
	</section>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
	<script src="<%=request.getContextPath()%>/javascript/script.js"></script>

</body>

</html>
