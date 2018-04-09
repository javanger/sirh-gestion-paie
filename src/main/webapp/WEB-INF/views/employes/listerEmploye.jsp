<%@page import="dev.paie.entite.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-QAdi7HQouHzrMcg66qFdsKV2BCFW/iVhCRvooAkqS4d5rXV8Hlu+X8MY3ao03fgn" crossorigin="anonymous">
		<title>Employe</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	      <a class="navbar-brand" href="../..">Accueil</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarSupportedContent">
	        <ul class="navbar-nav mr-auto">
	          <li class="nav-item active"><a class="nav-link" href="../employes/lister">Employés</a></li>
	          <li class="nav-item"><a class="nav-link" href="../bulletins/lister">Bulletins</a></li>
	        </ul>
	      </div>
	    </nav>
	
		<div class="container-fluid">
			<div class="row justify-content-center p-2">
				<h1>Liste des employés</h1>
			</div>
			<sec:authorize access="hasRole('ADMINISTRATEUR')">
				<div class="row ">
					<div class="col-10 text-right">
		        		<a href="../employes/creer"><button type="submit"  class="btn btn-primary">Ajouter un nouvel employé</button></a>
		        	</div>
		       	</div>
	       	</sec:authorize>
	       	
	       	<div class = "row mt-3">
	       		<div class ="col-9 offset-1">
					<table class="table">
						<thead class="table-dark">
							<tr>
								<th>Date/heure de création</th>
								<th>Matricule</th>
								<th>Grade</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employe }" var="employe">
								<tr>
									<td>
										${employe.dateCreation} 
									</td>
									<td>
										${employe.matricule } 
									</td>
									<td>
										${employe.grade.code }
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>  
				</div>    	
	       	</div>
	       	
	       	
	       	
		
		</div>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>