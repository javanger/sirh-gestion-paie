<!--  
<h1>Créer Employe</h1>
<p>Préfixe Matricule : ${prefixMatricule}</p>
-->
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Liste employés</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>

<body>
							<div class="container-fluid">
								<div class="row card">
									<nav class="navbar navbar-expand-lg navbar-light bg-light">


										<div class="collapse navbar-collapse"
											id="navbarSupportedContent">
											<ul class="navbar-nav mr-auto">
												<li class="nav-item active"><a class="nav-link "
													href='<c:url value="/mvc/employes/lister"></c:url>'>Employés</a></li>
												<li class="nav-item"><a class="nav-link"
													href='<c:url value="/mvc/bulletins/lister"></c:url>'>Bulletins</a></li>

											</ul>
										</div>
									</nav>
								</div>
							</div>




							<div class="container-fluid" class="mx-auto">
								<div class="row">


									<div class="text-center col-md-12">
										<div class="container-fluid">
											<div class="row">
												<div class="col">
													<h1>Liste des employés</h1>
												</div>

											</div>


											<div class="row">

												<div class="col-10"></div>
												<div class="col-2">
													<a class="btn btn-dark" href='<c:url value="/mvc/employes/creer"></c:url>'>Ajouter un employé</a>
												</div>
												<table class="table table-striped">
													<thead>
														<tr class="table">
															<th class="col-6">Date/Heure de création</th>
															<th class="col-2">Matricule</th>
															<th class="col-4">Grade</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${employes}" var="employ">
															<tr class="table">
																<td>${employ.dateCreation}</td>
																<td>${employ.matricule}</td>
																<td>${employ.grade.code}</td>

															</tr>
														</c:forEach>

													</tbody>
												</table>



											</div>



										</div>
									</div>
								</div>

							</div>









						</body>
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

<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');

			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				// si l'ur est creer-collab.html?errors 
				if (window.location.search == "?errors") {
					form.classList.add('was-validated');
				}
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>

</html>