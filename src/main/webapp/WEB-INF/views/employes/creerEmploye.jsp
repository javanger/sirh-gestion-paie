<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href='<c:url value="/index.jsp" />'>Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href='<c:url value="/mvc/employes/lister" />'>Employés</a>
					</li>
					<li class="nav-item"><a class="nav-link" href='<c:url value="/mvc/bulletins/lister" />'>Bulletins</a>
					</li>
				</ul>
			</div>
		</nav>
		<section>
			<article>
				<div class="row pl-5">
					<div class="col-3 p-3">
						<a href="<c:url value="/mvc/employes/lister" />">
							<img src='<c:out value="/images/fleche.png"/>' class="img-fluid" alt="Responsive image"/>
						</a>
					</div>
					<div class="col-6 text-center p-2 p-m-4">
						<h1>Ajouter un employé</h1>
					</div>
				</div>
				<form:form method="POST" modelAttribute="remunerationEmploye" accept-charset="UTF-8">
					<div class="form-group row p-3 pl-5">
						<label for="inputMatricule" class="col-sm-2 col-form-label">Matricule
							: </label>
						<div class="col-sm-8">
							<form:input type="text" path="matricule" class="form-control" id="inputMatricule"
								name="matricule" placeholder="Matricule"/>
						</div>
					</div>
					<div class="form-group row p-3 pl-5">
						<label for="selectEntreprise" class="col-sm-2 col-form-label">Entreprise
							: </label>
						<div class="col-sm-8">
							<form:select path="entreprise.id" items="${entreprises}" itemValue="id" itemLabel="denomination" class="form-control"  id="selectEntreprise"
								name="entreprise">
							</form:select>
						</div>
					</div>
					<div class="form-group row p-3 pl-5">
						<label for="selectProfil" class="col-sm-2 col-form-label">Profil
							: </label>
						<div class="col-sm-8">
							<form:select path="profilRemuneration.id" items="${profils}" itemValue="id" itemLabel="code" class="form-control" id="selectProfil" name="profil">
							</form:select>
						</div>
					</div>
					<div class="form-group row p-3 pl-5">
						<label for="selectGrade" class="col-sm-2 col-form-label">Grade
							: </label>
						<div class="col-sm-8">
							<form:select path="grade.id" class="form-control" id="selectGrade" name="grade">
								<c:forEach items="${grades}" var="grade">
									<form:option value="${grade.key.id}" label="${grade.value}"></form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="col-sm-10 text-right p-3">
						<button class="btn btn-primary" id="creerCollaboratuer"
							type="submit">Ajouter</button>
					</div>
				</form:form>
			</article>
		</section>
	</div>
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