<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
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
					<li class="nav-item"><a class="nav-link" href="./lister">Employ&#xe9s
					</a></li>
					<li class="nav-item"><a class="nav-link" href="./lister">Bulletins</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 offset-5 mt-5">
				<h2>Liste des employés</h2>
			</div>
		</div>
		<section>
			<div class="row">
				<div class="col-lg-9"></div>
				<div class="col-12 col-lg-1 offset-1">
					<a href="./creer" class="btn btn-primary mt-3">Ajouter
						un employé</a>
				</div>
			</div>
			<div class="row">

				<div class="col-12 col-lg-10 offset-1 mt-5">
					<div class="responsive">
						<table class="table">
							<caption></caption>
							<thead class="thead-light">
								<tr>

									<th scope="col">Date/heure création</th>
									<th scope="col">Matricule</th>
									<th scope="col">Grade</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${remunerationEmployes}" var="remunerations">
									<tr>
										<td class="table-primary">${remunerations.creationMois}</td>
										<td class="table-secondary">${remunerations.matricule}</td>
										<td class="table-primary">${remunerations.grade.code}</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>




					</div>
				</div>
			</div>
	</div>
	</section>

</body>

</html>