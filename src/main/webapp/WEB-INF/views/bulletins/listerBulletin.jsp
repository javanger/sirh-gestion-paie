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
      		<div class="row justify-content-center p-2">
      			<header>
					<h1>Liste des bulletins</h1>
				</header>	
      		</div>	     				
		</div>			
			<div class="row justify-content-end mt-2 p-2">
	        	<div class=".col-auto">
	          		<a href='<c:url value="/mvc/bulletins/creer.jsp"/>'><button class="btn btn-primary">Créer un nouveau bulletin</button></a>
	        	</div>
      		</div>
		
		<table class="table table-hover table-dark">
		  <thead>
		    <tr>
		      <th scope="col">Date/Heure de création</th>
		      <th scope="col">Periode</th>
		      <th scope="col">Matricule</th>
		      <th scope="col">Salaire Brut</th>
		      <th scope="col">Net Imposable</th>
		      <th scope="col">Net A Payer</th>
		      <th scope="col">Actions</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${bulletinSalaires}" var="bulletin">
		  	<tr>

		      <td>${bulletin.key.creationString}</td>
		      <td>${bulletin.key.periode.debutFin}</td>
		      <td>${bulletin.key.remunerationEmploye.matricule}</td>
		      <td>${bulletin.value.salaireBrut}</td>
		      <td>${bulletin.value.netImposable}</td>
		      <td>${bulletin.value.netAPayer}</td> 
		 	  <td><a href='<c:url value="/mvc/bulletins/visualiser/${bulletin.key.id}"/>' class="text-white">Visualiser</a></td>
		    </tr>
		 	  
		  	</c:forEach>  
		  </tbody>
		</table>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>