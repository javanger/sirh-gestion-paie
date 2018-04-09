<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="fr">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-
	dist/css/bootstrap.css">
  <head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, user-scalable=no, initial-
    scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/journal/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  </head>
  <body>
    <a class="navbar-brand" href="#">Menu</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
       <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="../employes/lister">Employés<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../bulletins/lister">Bulletins</a>
            </li>
          </ul>
        </div>
          </nav>
          <div class="col-sm-12 col-xs-12 col-lg-12 col-mg-12">
      			<h1>Liste des bulletins</h1>
      		</div>
      		<sec:authorize access="hasRole('ADMINISTRATEUR')">
            <div class="form-group">
			<a href="../bulletins/creer"><button  type="submit" id="buttoncreer" class="btn btn-primary btn-lg" >
                creer un nouveau bulletin
            </button></a>
            </div>
            </sec:authorize>
            <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Date/heure création</th>
      <th scope="col">Periode</th>
      <th scope="col">Matricule</th>
      <th scope="col">Salaire brut</th>
      <th scope="col">Net Impossable</th>
      <th scope="col">Net à payer </th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${bulletinSalaire}" var="bulletins">
    <tr class="table-active">   
      <td>${bulletins.key.creation}</td>
      <td>${bulletins.key.periode.periode}</td>
      <td>${bulletins.key.remunerationEmploye.matricule}</td>
      <td>${bulletins.value.salaireBrut}</td>
      <td>${bulletins.value.netImposable}</td>
      <td>${bulletins.value.netAPayer}</td> 
      <td><a href="../bulletins/visualiser">Visualiser</a></td>
      </tr>
      </c:forEach>
  </tbody>
</table>
</body>
</html>