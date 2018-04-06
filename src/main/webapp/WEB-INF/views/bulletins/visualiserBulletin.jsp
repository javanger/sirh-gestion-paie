<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Statistiques</title>
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
					<li class="nav-item"><a class="nav-link" href="./lister">Bulletins</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 offset-0 mt-3">
				<a href="./liser"><img src="fleche.png" alt=""></a>
			</div>

			<div class="col-lg-4 offset-3 mt-5">

				<h2>Bulletin de Salaire</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-4  offset-8 mt-2">
				<h4>Période</h4>
				<label>${periode}</label>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 offset-1 ">
				<h4>Entreprise</h4>
				<p>DEV ENTREPRISE</p>
				<p>SIRET</p>

			</div>
		</div>

		<section>
			<div class="row">

				<div class="col-12 col-lg-10 offset-1 mt-5">
					<div class="responsive">
						<p>
							<strong>Salaire</strong>
						</p>
						<table class="table">
							<caption></caption>
							<thead class="thead-light">


								<tr>

									<th scope="col">Rubriques</th>
									<th scope="col">Base</th>
									<th scope="col">Taux Salarial</th>
									<th scope="col">Montant</th>
									<th scope="col">Taux patronal</th>
									<th scope="col">Cot. patronal</th>
								</tr>

							</thead>
							<tbody>
								<c:forEach items="${bulletinSalaire}" var="salaire">
									<tr>
										<th class="table-primary">${cotisation.code}</th>
										<td class="table-secondary">${cotisation.code}</td>
										<td class="table-primary">${cotisation.code}</td>
										<td class="table-secondary">${cotisation.code}</td>
										<td class="table-primary">${cotisation.tauxPatronal}</td>
										<td class="table-secondary">${cotisation.tauxPatronal}</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>




					</div>
				</div>
			</div>
		</section>
		<section>
			<div class="row">

				<div class="col-12 col-lg-10 offset-1 mt-5">
					<div class="responsive">
						<p>
							<strong>Cotisations</strong>
						</p>
						<table class="table">
							<caption></caption>
							<thead class="thead-light">
								<tr>

									<th scope="col">Rubriques</th>
									<th scope="col">Base</th>
									<th scope="col">Taux Salarial</th>
									<th scope="col">Montant</th>
									<th scope="col">Taux patronal</th>
									<th scope="col">Cot. patronal</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${bulletinSalaire}" var="salaire">
									<tr>
										<th class="table-primary">${cotisation.code}</th>
										<td class="table-secondary">${cotisation.code}</td>
										<td class="table-primary">${cotisation.code}</td>
										<td class="table-secondary">${cotisation.code}</td>
										<td class="table-primary">${cotisation.tauxPatronal}</td>
										<td class="table-secondary">${cotisation.tauxPatronal}</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>




					</div>
				</div>
			</div>
		</section>
		<section>
			<div class="row">

				<div class="col-12 col-lg-10 offset-1 mt-5">
					<div class="responsive">
						<p>
							<strong> Imposable : XXXXX</strong>
						</p>
						<table class="table">
							<caption></caption>
							<thead class="thead-light">
								<tr>

									<th scope="col">Rubriques</th>
									<th scope="col">Base</th>
									<th scope="col">Taux Salarial</th>
									<th scope="col">Montant</th>
									<th scope="col">Taux patronal</th>
									<th scope="col">Cot. patronal</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${bulletinSalaire}" var="salaire">
									<tr>
										<th class="table-primary">${cotisation.code}</th>
										<td class="table-secondary">${cotisation.code}</td>
										<td class="table-primary">${cotisation.code}</td>
										<td class="table-secondary">${cotisation.code}</td>
										<td class="table-primary">${cotisation.tauxPatronal}</td>
										<td class="table-secondary">${cotisation.tauxPatronal}</td>

									</tr>
								</c:forEach>							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		<section>
			<div class="row">
				<div class="col-4  offset-8 mt-2">
					<p><strong>NET A PAYER :</strong></p>
					<p>${netAPayer}</p>
				</div>
			</div>

		</section>
	</div>
</body>

</html>