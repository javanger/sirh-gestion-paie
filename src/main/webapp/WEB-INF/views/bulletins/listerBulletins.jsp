<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lister bulletins</title>

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

				<li class="nav-item"><a class="nav-link" href="lister">Bulletin
				</a></li>

				<li class="nav-item"><a class="nav-link" href="../employes/lister">Employé</a></li>

			</ul>

		</div>
	</nav>

	<div class="container-fluid">

		<table class="table">

			<thread>
			<tr>
				<th>Date de création</th>
				<th>Période</th>
				<th>Matricule</th>
				<th>Salaire brut</th>
				<th>Net Imposable</th>
				<th>Net A Payer</th>
				<th>Actions</th>
			</tr>
			</thread>

			<c:forEach items="${bulletins}" var="bulletin">

				<fmt:parseNumber var="salaireBrut" type="number"
					value="${bulletin.value.salaireBrut}" />
				<fmt:parseNumber var="netImposable" type="number"
					value="${bulletin.value.netImposable}" />
				<fmt:parseNumber var="netAPayer" type="number"
					value="${bulletin.value.netAPayer}" />

				<tr>
					<td>${bulletin.key.dateCreation}</td>
					<td>${bulletin.key.periode.dateDebut} - ${bulletin.key.periode.dateFin}</td>
					<td>${bulletin.key.remunerationEmploye.matricule}</td>
					<td>${salaireBrut}</td>
					<td>${netImposable}</td>
					<td>${netAPayer}</td>
					<td>Visualiser</td>
				</tr>

			</c:forEach>

		</table>

		<div class="row justify-content-end mt-2 mr-2">

			<div class=".col-auto">
				<a href='creer'>
					<button type="button" class="btn btn-outline-dark">Créer
						un nouveau bulletin</button>
				</a>

			</div>

		</div>

	</div>

</body>
</html>