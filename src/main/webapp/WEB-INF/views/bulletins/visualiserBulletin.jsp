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
				<div class="row pl-5 pt-4">
					<div class="col-3 p-3">
						<a href="<c:url value="/mvc/bulletins/lister" />"> <img
							src='<c:url value="/images/fleche.png"/>' class="img-fluid"
							alt="Responsive image" />
						</a>
					</div>
					<div class="col-6 text-center p-2 p-m-4">
						<h1>Bulletin de Salaire</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-4 p-4">
						<h6>Entreprise</h6>
						<p>
							<c:out
								value="${bulletin.remunerationEmploye.entreprise.denomination}"></c:out>
						</p>
						<p>
							Siret :
							<c:out value="${bulletin.remunerationEmploye.entreprise.siret}"></c:out>
						</p>
					</div>
					<div class="col-4 offset-4 text-right p-2">
						<h6>Période</h6>
						<p>
							Du
							<c:out value="${bulletin.periode.dateDebut}"></c:out>
							Au
							<c:out value="${bulletin.periode.dateFin}"></c:out>
						</p>
						<br />
						<p>
							Matricule :
							<c:out value="${bulletin.remunerationEmploye.matricule}"></c:out>
						</p>
					</div>
				</div>
				<div class="row p-3">
					<div class="col-12">
						<h6>Salaire</h6>
					</div>
					<div class="col-12">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Rubriques</th>
									<th scope="col">Base</th>
									<th scope="col">Taux Salarial</th>
									<th scope="col">Montant Salarial</th>
									<th scope="col">Taux Patronal</th>
									<th scope="col">Cot. patronales</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Salaire de base</td>
									<td><c:out
											value="${bulletin.remunerationEmploye.grade.nbHeuresBase}"></c:out></td>
									<td><c:out
											value="${bulletin.remunerationEmploye.grade.tauxBase}"></c:out></td>
									<td><c:out value="${calcul.salaireDeBase}"></c:out></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>Prime Except.</td>
									<td></td>
									<td></td>
									<td><c:out value="${bulletin.primeExceptionnelle}"></c:out></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>Salaire Brut</td>
									<td></td>
									<td></td>
									<td><c:out value="${calcul.salaireBrut}"></c:out></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row p-3">
					<div class="col-12">
						<h6>Cotisations</h6>
					</div>
					<div class="col-12">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Rubriques</th>
									<th scope="col">Base</th>
									<th scope="col">Taux Salarial</th>
									<th scope="col">Montant Salarial</th>
									<th scope="col">Taux Patronal</th>
									<th scope="col">Cot. patronales</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cotisationsNonImposables}"
									var="cotisationNonImposable">
									<tr>
										<td><c:out value="${cotisationNonImposable.code}"></c:out>
											<c:out value="${cotisationNonImposable.libelle}"></c:out></td>
										<td><c:out value="${calcul.salaireBrut}"></c:out></td>
										<td><c:out value="${cotisationNonImposable.tauxSalarial}"></c:out></td>
										<td><c:out
												value="${cotisationNonImposable.montantSalarial}"></c:out></td>
										<td><c:out value="${cotisationNonImposable.tauxPatronal}"></c:out></td>
										<td><c:out
												value="${cotisationNonImposable.montantPatronal}"></c:out></td>
									</tr>
								</c:forEach>
								<tr>
									<td>Total Retenue</td>
									<td></td>
									<td></td>
									<td><c:out value="${calcul.totalRetenueSalarial}"></c:out></td>
									<td></td>
									<td><c:out value="${calcul.totalCotisationsPatronales}"></c:out></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row p-3">
					<div class="col-12">
						<h6>
							Net Imposables :
							<c:out value="${calcul.netImposable}"></c:out>
						</h6>
					</div>
					<div class="col-12">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Rubriques</th>
									<th scope="col">Base</th>
									<th scope="col">Taux Salarial</th>
									<th scope="col">Montant Salarial</th>
									<th scope="col">Taux Patronal</th>
									<th scope="col">Cot. patronales</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cotisationsImposables}"
									var="cotisationImposable">
									<tr>
										<td><c:out value="${cotisationImposable.code}"></c:out> <c:out
												value="${cotisationImposable.libelle}"></c:out></td>
										<td><c:out value="${calcul.salaireBrut}"></c:out></td>
										<td><c:out value="${cotisationImposable.tauxSalarial}"></c:out></td>
										<td><c:out value="${cotisationImposable.montantSalarial}"></c:out></td>
										<td><c:out value="${cotisationImposable.tauxPatronal}"></c:out></td>
										<td><c:out value="${cotisationImposable.montantPatronal}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row p-3">
					<div class="col-12 text-right">
						<h6>
							NET A PAYER :
							<c:out value="${calcul.netAPayer}"></c:out>
						</h6>
					</div>
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