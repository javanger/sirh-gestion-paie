<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bulletins</title>
		<link href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/lux/bootstrap.min.css" rel="stylesheet" integrity="sha384-GxhP7S92hzaDyDJqbdpcHqV5cFflxAx0Yze/X7vUONp43KK1E8eUWaJIMkit3D0R" crossorigin="anonymous">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href='<c:url value="/index.jsp"/>'>Home</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href='<c:url value="/mvc/employes/lister.jsp"/>'>Employés</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href='<c:url value="/mvc/bulletins/lister.jsp"/>'>Bulletins</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		<div class="container-fluid">	
			<div class="row justify-content-start mt-2 p-2">
	        	<div class=".col-auto">
	          		<a href='<c:url value="/index.jsp"/>'><img src="<%=request.getContextPath()%>/image/retour.jpg" class="rounded"></a>
	        	</div>
      		</div>	
      		<div class="row justify-content-center p-2">
      			<header>
					<h1>Bulletin de Salaire</h1>
				</header>	
      		</div>	     				

			<div class="row">
				<div class="col-6">
					<p>Entreprise</p>
					<p>${bulletin.remunerationEmploye.entreprise.denomination}</p>
					<p>SIRET : ${bulletin.remunerationEmploye.entreprise.siret}</p>
				</div>
				<div class="col-6">
					<p>Période</p>
					<p>Du : ${bulletin.periode.dateDebut} au ${bulletin.periode.dateFin}</p>
					<p>Matricule : ${bulletin.remunerationEmploye.matricule}</p>
				</div>		 
			</div>		
			<!-- Table Salaire -->
			<h5>Salaire</h5>
			<table class="table table-hover table-dark">
			  <thead>
			    <tr>
			      <th scope="col">Rubrique</th>
			      <th scope="col" class="text-center">Nombre d'Heure)</th>
			      <th scope="col" class="text-center">Taux</th>
			      <th scope="col" class="text-center">Montant</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<tr>
			      <td>Salaire de Base</td>
			      <td class="text-center">${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
			      <td class="text-center">${bulletin.remunerationEmploye.grade.tauxBase}</td>
			      <td class="text-center">${calcul.salaireDeBase}</td>
			    </tr>
				<tr>
			      <td>Prime Exceptionnelle</td>
			      <td></td>
			      <td></td>
			      <td class="text-center">${bulletin.primeExceptionnelle}</td>
			    </tr>
			    <tr>
			      <td>Salaire Brut</td>
			      <td></td>
			      <td></td>
			      <td class="text-center">${calcul.salaireBrut}</td>
			    </tr>
			  </tbody>
			</table>
			<!-- Table Cotisation Non Impossable-->
			<h5>Cotisations</h5>
			<table class="table table-hover table-dark">
			  <thead>
			    <tr>
			      <th scope="col">Rubrique</th>
			      <th scope="col" class="text-center">Base</th>
			      <th scope="col" class="text-center">Taux Salarial</th>
			      <th scope="col" class="text-center">Montant Salarial</th>
			      <th scope="col" class="text-center">Taux Patronal</th>
			      <th scope="col" class="text-center">Cotisation patronales</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${cotCalcul}" var="cotisationNonImposable">
			  	<tr>
			      <td>${cotisationNonImposable.cotisation.code} - ${cotisationNonImposable.cotisation.libelle}</td>
			      <td class="text-center">${calcul.salaireBrut}</td>
			      <td class="text-center">${cotisationNonImposable.cotisation.tauxSalarial}</td>
			      <td class="text-center">${cotisationNonImposable.montantSalarial}</td>
			      <td class="text-center">${cotisationNonImposable.cotisation.tauxPatronal}</td>
			      <td class="text-center">${cotisationNonImposable.cotisationPatronal}</td> 
			    </tr>
			  	</c:forEach>  
			  	<tr>
			      <td>Total Retenue</td>
			      <td class="text-center"></td>
			      <td class="text-center"></td>
			      <td class="text-center">${calcul.totalRetenueSalarial}</td>
			      <td class="text-center"></td>
			      <td class="text-center">${calcul.totalCotisationsPatronales}</td> 
			    </tr>	
			  </tbody>
			</table>
			<!-- Tabe Net Imposable -->
			<h5>Net Imposable : <c:out value="${calcul.netImposable}"/></h5>
			<table class="table table-hover table-dark">
			  <thead>
			    <tr>
			      <th scope="col">Rubrique</th>
			      <th scope="col" class="text-center">Base</th>
			      <th scope="col" class="text-center">Taux Salarial</th>
			      <th scope="col" class="text-center">Montant Salarial</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${cotCalculImposable}" var="cotisationImposable">
			  	<tr>
			      <td>${cotisationImposable.cotisation.code} - ${cotisationImposable.cotisation.libelle}</td>
			      <td class="text-center">${calcul.salaireBrut}</td>
			      <td class="text-center">${cotisationImposable.cotisation.tauxSalarial}</td>
			      <td class="text-center">${cotisationImposable.montantSalarial}</td>
			    </tr>
			  	</c:forEach>  
			  </tbody>	
			</table>
			<div class="row justify-content-end mt-5 p-2">
				<p>NET A PAYER : <c:out value="${calcul.netAPayer}"/></p>
			</div>
			    
		</div>	
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>