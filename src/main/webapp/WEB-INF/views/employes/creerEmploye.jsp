<%@page import="java.util.List"%>
<%@page import="dev.paie.entite.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link
			href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/sketchy/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QAdi7HQouHzrMcg66qFdsKV2BCFW/iVhCRvooAkqS4d5rXV8Hlu+X8MY3ao03fgn"
			crossorigin="anonymous">
		<title>Employe</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"> 
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="lister">Employés</a></li>
					<li class="nav-item"><a class="nav-link" href="">Bulletins</a></li>
				</ul>
			</div>
		</nav>
		<div class="container-fluid">
			<div class="row justify-content-center p-2">
				
					<h1>Ajouter un employé</h1>
				
			</div>
			<form:form method="POST" modelAttribute="remunerationEmploye">
				<div class="row mb-3">
					<div class="col-2 offset-2">
						<label class="col-form-label">Matricule</label>
					</div>
					<div class="col-4">
						<form:input path="matricule" class="form-control" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-2 offset-2">
						<label class="col-form-label">Entreprise</label>
					</div>
					<div class="col-4">
						<div class="form-group">
							<form:select path="entreprise.id" class="form-control" >
								<c:forEach items="${entreprise }" var="entreprise">
									<form:option value="${entreprise.getId()}"> ${entreprise.getDenomination()} </form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-2 offset-2">
						<label class="col-form-label">Profil</label>
					</div>
					<div class="col-4">
						<div class="form-group">
							<form:select path="profilRemuneration.id" class="form-control" >
								<c:forEach items="${profil }" var="profil">
									<form:option value="${profil.getId()}"> ${profil.getCode()} </form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-2 offset-2">
						<label class="col-form-label">Grade</label>
					</div>
					<div class="col-4">
						<div class="form-group">
							<form:select path="grade.id" class="form-control" >
								<c:forEach items="${grade }" var="grade">
									<form:option value="${grade.getId()}"> ${grade.getCode()} </form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
	
				<div class="row mb-3">
					<div class="col offset-7">
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>
				</div>
			</form:form>
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