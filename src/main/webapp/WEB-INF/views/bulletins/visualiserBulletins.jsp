<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          <div class="container">
 			 <div class="row justify-content-md-center">
          <div class="col-md-6 offset-md-3">
      			<h1>Bulletins de Salaire</h1>
      		</div>
      		</div>
      		</div>
      		<div class="row justify-content-end">
           <div class="col offset-10">
           <h3>Periode</h3>
          <p></p>
           </div>
           </div>
           <div class="row ">
           <div class="col-3 offset-1">
           <h3>Entreprise</h3>
           <p>DEV ENTREPRISE</p>
           <p>SIRET:</p>
           <p items="${periodes}" var="periodes.id">${periodes.periode}</p>
           </div>
           <div class="col-3 offset-5">
           <h3>Matricule</h3>
           </div>
           </div>
           
           <div class="row ">
           <div class="col-3">
           <h4>Salaire</h4>
           </div>
           </div>
           <div class="col">
				           <table class="table">
				  <thead class="thead-dark">
				    <tr class="table-info">
				      <th scope="col">Rubriques</th>
				      <th scope="col">Base</th>
				      <th scope="col">Taux salarial</th>
				      <th scope="col">Montant salarial</th>
				      <th scope="col">Taux patronal</th>
				      <th scope="col">Cot. patronales</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr class="table-info">
				      <th scope="row">Salaire de base</th>
				      <td>151.67</td>
				      <td>11.0984</td>
				      <td>1683.30</td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">Prime Except.</th>
				      <td></td>
				      <td></td>
				      <td>1000</td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row"></th>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">Salaire Brut</th>
				      <td></td>
				      <td></td>
				      <td>2683.30</td>
				      <td></td>
				      <td></td>
				    </tr>
				  </tbody>
				</table>
           </div>
           
           <div class="row ">
           <div class="col-3">
           <h4>Cotisations</h4>
           </div>
           </div>
           <div class="col">
				           <table class="table">
				  <thead class="thead-dark">
				    <tr class="table-info">
				      <th scope="col">Rubriques</th>
				      <th scope="col">Base</th>
				      <th scope="col">Taux salarial</th>
				      <th scope="col">Montant salarial</th>
				      <th scope="col">Taux patronal</th>
				      <th scope="col">Cot. patronales</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr class="table-info">
				      <th scope="row">EP01 URSSAF Maladie...</th>
				      <td>2683.30</td>
				      <td>XXXX</td>
				      <td>XXXX</td>
				      <td>XXXX</td>
				      <td>XXXX</td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">EP01 URSSAF Solidarité</th>
				      <td>2683.30</td>
				      <td>XXXX</td>
				      <td>XXXX</td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">...</th>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">...</th>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">Total Retenue</th>
				      <td></td>
				      <td></td>
				      <td>XXXX</td>
				      <td></td>
				      <td>XXXX</td>
				    </tr>
				  </tbody>
				</table>
           </div>
				
           <div class="row ">
           <div class="col-3">
           <h4>NET Imposable : XXXXX</h4>
           </div>
           </div>
           <div class="col">
				           <table class="table">
				  <thead class="thead-dark">
				    <tr class="table-info">
				      <th scope="col">Rubriques</th>
				      <th scope="col">Base</th>
				      <th scope="col">Taux salarial</th>
				      <th scope="col">Montant salarial</th>
				      <th scope="col">Taux patronal</th>
				      <th scope="col">Cot. patronales</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr class="table-info">
				      <th scope="row">SP01 URSSAF CSG NON DEDUCTIBLE</th>
				      <td>2683.30</td>
				      <td>XXXX</td>
				      <td>XXXX</td>
				      <td></td>
				      <td></td>
				    </tr>
				    <tr class="table-info">
				      <th scope="row">SXX XXXXXX</th>
				      <td>2683.30</td>
				      <td>XXXX</td>
				      <td>XXXX</td>
				      <td></td>
				      <td></td>
				    </tr>
				  </tbody>
				</table>
           </div>
           
           
</body>
</html>