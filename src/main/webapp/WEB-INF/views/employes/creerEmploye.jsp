<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création</title>

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

				<li class="nav-item"><a class="nav-link" href="#">Bulletin
				</a></li>

			</ul>

		</div>
	</nav>

	<div class="container-fluid">

		<form:form class="needs-validation mt-4" method="post"
			modelAttribute="remunerationEmploye" novalidate="novalidate">

			<div class="form-row justify-content-center">
				<div class="col-10 col-sm-8 col-md-6 col-lg-4 mb-3">
					<label for="matriculeInput">Matricule</label>
					<form:input path="matricule" type="text" class="form-control"  placeholder="matricule" required="required" />
					<div class="invalid-feedback">Veuillez saisir un matricule
						correct.</div>
				</div>
			</div>

			<div class="form-row justify-content-center">
				<div class="col-10 col-sm-8 col-md-6 col-lg-4 mb-3">

					<label for="entrepriseInput">Entreprise</label>
					
					<form:select class="custom-select" items="${entreprises}" itemLabel="denomination" itemValue="id" path="entreprise.id"></form:select>

				</div>
			</div>

			<div class="form-row justify-content-center">
				<div class="col-10 col-sm-8 col-md-6 col-lg-4 mb-3">

					<label for="profilInput">Profil</label>
					
					<form:select class="custom-select" items="${profils}" itemLabel="code" itemValue="id" path="profilRemuneration.id"></form:select>

				</div>
			</div>

			<div class="form-row justify-content-center">
				<div class="col-10 col-sm-8 col-md-6 col-lg-4 mb-3">

					<label for="gradeInput">Grade</label>
					<form:select path="grade.id" class="custom-select">

						<c:forEach items="${grades}" var="grade">

							<fmt:parseNumber var="i" type="number"
								value="${grade.nbHeuresBase.multiply(grade.tauxBase).multiply(12)}" />

							<option value="${grade.id}">${grade.code} - ${i} € / an</option>
							
						</c:forEach>

					</form:select>

				</div>
			</div>

			<div class="form-row justify-content-end">
				<div class="col-10 col-sm-8 col-md-6 col-lg-4 mb-3">
					<button type="submit" class="btn btn-primary">Valider</button>
				</div>
			</div>
		</form:form>



	</div>

</body>
</html>