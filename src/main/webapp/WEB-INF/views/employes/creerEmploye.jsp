<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List,dev.paie.entite.Entreprise,dev.paie.entite.RemunerationEmploye"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employe</title>
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
		        <a class="nav-link" href="#">Bulletins</a>
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
					<h1>Ajouter un employé</h1>
				</header>	
      		</div>	 
       	
			
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
			<form:form method="post" modelAttribute="remunerationEmploye">
				<div class="form-group">
	    			<label for="formMatricule">Matricule</label>
	    			<form:input type="text" path="matricule" class="form-control" id="formMatricule" placeholder="Matricule"/>
	  			</div>
	  			<label for="formEnteprise">Entreprise</label>
	  			<form:select path="entreprise.id" class="form-control" id="formEnteprise">
					<form:options items="${entreprises}" itemValue="id" itemLabel="denomination"/>	
				</form:select>
				<label for="formProfil">Profil</label>
				<form:select path="profilRemuneration.id" class="form-control" id="formProfil">
					<form:options items="${profils}" itemValue="id" itemLabel="code"/>	
				</form:select>
				<label for="formGrade">Grade</label>
				<form:select path="grade.id" class="form-control" id="formGrade">
					<form:options items="${grades}" itemValue="id" itemLabel="code"/>	
				</form:select>
				<div class="row justify-content-center mt-3 p-2">
					<input class="btn btn-primary" type="submit" value="Ajouter">
				</div>

			</form:form>
		</div>
	
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>