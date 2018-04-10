<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>PAIE</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/materia/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-kpxyUW5uLgBOlhLqm8Hga/aWgf7FgZWLhphVqsMgaW0s+G6KF1RZpUb6ygQL3WUE"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href='<c:url value="/index.jsp" />'>Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div id="navbarNav" class="collapse navbar-collapse">
				<ul class="navbar-nav mr-md-auto">
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/mvc/employes/lister" />'>Employés</a></li>
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/mvc/bulletins/lister" />'>Bulletins</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/mvc/employes/lister" />'>Déconnexion</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section>
		<div class="container">
			<article>
				<div class="row p-3 pt-4">
					<div class="col-6 offset-3 text-center">
						<h1>Liste des Bulletins</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-12 col-md-12 col-12 text-right">
						<a href='<c:url value="/mvc/bulletins/creer" />'
							class="btn btn-secondary">Créer un nouveau bulletin</a>
					</div>
				</div>
				<div class="row p-3">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Date/heure création</th>
								<th scope="col">Période</th>
								<th scope="col">Matricule</th>
								<th scope="col">Salaire brut</th>
								<th scope="col">Net Imposable</th>
								<th scope="col">Net A Payer</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bulletinServices}" var="bulletinService"
								varStatus="status">
								<tr>
									<td><c:out
											value="${bulletinService.key.dateCreationString}"></c:out></td>
									<td><c:out
											value="${bulletinService.key.periode.dateString}"></c:out></td>
									<td><c:out
											value="${bulletinService.key.remunerationEmploye.matricule}"></c:out></td>
									<td><c:out value="${bulletinService.value.salaireBrut}"></c:out></td>
									<td><c:out value="${bulletinService.value.netImposable}"></c:out></td>
									<td><c:out value="${bulletinService.value.netAPayer}"></c:out></td>
									<td><a
										href='<c:url value="/mvc/bulletins/visualiser/${bulletinService.key.id}" />'><c:out
												value="Visualiser"></c:out></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</article>
		</div>
	</section>

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
</body>
</html>