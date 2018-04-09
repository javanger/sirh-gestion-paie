<%@page import="dev.paie.entite.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-QAdi7HQouHzrMcg66qFdsKV2BCFW/iVhCRvooAkqS4d5rXV8Hlu+X8MY3ao03fgn" crossorigin="anonymous">
		<title>Bulletins</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	      <a class="navbar-brand" href="../..">Accueil</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarSupportedContent">
	        <ul class="navbar-nav mr-auto">
	          <li class="nav-item active"><a class="nav-link" href="../../employes/lister">Employés</a></li>
	          <li class="nav-item"><a class="nav-link" href="../../bulletins/lister">Bulletins</a></li>
	        </ul>
	      </div>
	    </nav>
	
		<div class="container-fluid">
			<div class="row justify-content-center p-2">
				<h1>Bulletin de salaire</h1>
			</div>
	       	<div class="row">
	       		<div class="col-10">
	       			<h4 class="float-right">Période</h4>
	       		</div>
	       	</div>
	       	
	       	<div class="row">
	       		<div class="col-10">
	       			<p class="float-right">Du ${bulletin.periode.dateDebut } au ${bulletin.periode.dateFin }</p>
	       		</div></div>
	       	<div class="row">
	       		<div class ="col offset-1">
	       			<h4>Entreprise</h4>
	       		</div>
	       	</div>
	       	<div class="row">
	       		<div class ="col offset-1">
	       			<p>${bulletin.remunerationEmploye.entreprise.denomination}</p>
	       		</div>
	       	</div>
	       	<div class="row">
	       		<div class ="col-5 offset-1">
	       			<p>SIRET : ${bulletin.remunerationEmploye.entreprise.siret}</p>
	       		</div>
	       		<div class="col-4 text-right">
	       			<p>Matricule ${bulletin.remunerationEmploye.matricule}</p>
	       		</div>
	       	</div>
	       	
	       	
	       	
	       	
	       	<div class = "row mt-3">
	       		<div class="col offset-1">
	       			<h4>Salaire</h4>
	       		</div>
	       	</div>
	       	<div class = "row mt-3">
	       		<div class ="col-9 offset-1">
					<table class="table">
						<thead class="table-dark">
							<tr>
								<th>Rubriques</th>
								<th>Base</th>
								<th>Taux Salarial</th>
								<th>Montant Salarial</th>
								<th>Taux patronal</th>
								<th>Cot.patronales</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Salaire de base</td>	
								<td>${bulletin.remunerationEmploye.grade.nbHeuresBase }</td>	
								<td>${bulletin.remunerationEmploye.grade.tauxBase }</td>	
								<td>${resultat.salaireDeBase }</td>	
								<td></td>	
								<td></td>	
							</tr>
							<tr>
								<td>Prime Except</td>	
								<td></td>	
								<td></td>	
								<td>${bulletin.primeExceptionnelle }</td>	
								<td></td>	
								<td></td>	
							</tr>
							<tr>
								<td>Salaire brut</td>	
								<td></td>	
								<td></td>	
								<td>${resultat.salaireBrut}</td>	
								<td></td>	
								<td></td>	
							</tr>
						</tbody>
					</table> 
				</div>     	
	       	</div>
	       	<div class = "row mt-3">
	       		<div class="col offset-1">
	       			<h4>Cotisations</h4>
	       		</div>
	       	</div>
	       	<div class = "row mt-3">
	       		<div class ="col-9 offset-1">
					<table class="table">
						<thead class="table-dark">
							<tr>
								<th>Rubriques</th>
								<th>Base</th>
								<th>Taux Salarial</th>
								<th>Montant Salarial</th>
								<th>Taux patronal</th>
								<th>Cot.patronales</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables }" var="cotisation">
								<tr>
									<td>${cotisation.code } ${cotisation.libelle }</td>	
									<td>${resultat.salaireBrut}</td>	
									<td>${cotisation.tauxSalarial }</td>	
									<td>XXXX</td>	
									<td>${cotisation.tauxPatronal }</td>	
									<td>XXXX</td>
								</tr>
							</c:forEach>
							<tr>
								<td>Total Retenue</td>	
								<td></td>	
								<td></td>	
								<td>${resultat.totalRetenueSalarial}</td>	
								<td></td>	
								<td>${resultat.totalCotisationsPatronales}</td>	
							</tr>
						</tbody>
					</table> 
				</div>     	
	       	</div>
	       	
	       	<div class = "row mt-3">
	       		<div class="col offset-1">
	       			<h4>NET Impossable : ${resultat.netImposable}</h4>
	       		</div>
	       	</div>
	       	<div class = "row mt-3">
	       		<div class ="col-9 offset-1">
					<table class="table">
						<thead class="table-dark">
							<tr>
								<th>Rubriques</th>
								<th>Base</th>
								<th>Taux Salarial</th>
								<th>Montant Salarial</th>
								<th>Taux patronal</th>
								<th>Cot.patronales</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables }" var="cotisation">
								<tr>
									<td>${cotisation.code } ${cotisation.libelle }</td>	
									<td>${resultat.salaireBrut}</td>	
									<td>${cotisation.tauxSalarial }</td>	
									<td>XXXX</td>	
									<td></td>	
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table> 
				</div>     	
	       	</div>
	       	<div class = "row mt-3">
	       		<div class="col-10">
	       			<h4 class="float-right">NET A PAYER : ${resultat.netAPayer}</h4>
	       		</div>
	       	</div>
	       	
	       	
		
		</div>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>