<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>
	<jsp:attribute name="header">
       
		<div class="row">
		  <div class="col-4">
			<a href="${ path }/bulletins/lister">Retour</a>
		  </div>
		  <div class="col-8 self-align-center">
	         <h1>Bulletin de salaire</h1>
          </div>
		</div>
    </jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
	   <div class="row">
	       <div class="col-8">
        	   <h3>Entreprise</h3>
		       ${ b.bulletinSalaire.remunerationEmploye.entreprise.denomination }<br />
		       SIRET: ${ b.bulletinSalaire.remunerationEmploye.entreprise.siret }<br />
	       </div>
	       <div class="col-4">
               <h3>Période</h3> ${ b.periode }
               <br><br>   
		       <h3>Matricule</h3> ${ b.bulletinSalaire.remunerationEmploye.matricule }
	       </div>
	   </div>
       
       <h3>Salaire</h3>
       
       <table class="table table-sm table-striped">
          <thead>
            <tr>
              <th scope="col">Rubriques</th>
              <th scope="col">Base</th>
              <th scope="col">Taux Salarial</th>
              <th scope="col">Montant Salarial</th>
              <th scope="col">Taux Patronal</th>
              <th scope="col">Cot. patronales</th>
            </tr>
          </thead>
          <tbody>
              <tr>			                       
               <td>Salaire de base</td>
               <td>${ b.bulletinSalaire.remunerationEmploye.grade.nbHeuresBase }</td>
               <td>${ b.bulletinSalaire.remunerationEmploye.grade.tauxBase }</td>
               <td>${ b.resultatCRSM.salaireDeBase }</td>
               <td></td>
               <td></td>
               <td></td>
              </tr>
              <tr>                                   
               <td>Prime except.</td>
               <td></td>
               <td></td>
               <td>${ b.bulletinSalaire.primeExceptionnelle }</td>
               <td></td>
               <td></td>
               <td></td>
              </tr>
              <tr>                                   
              </tr>    
              <tr>                                   
               <td><strong>Salaire brut.</strong></td>
               <td></td>
               <td></td>
               <td><strong>${ b.resultatCRSM.salaireBrut }</strong></td>
               <td></td>
               <td></td>
               <td></td>
              </tr>          
          </tbody>
        </table>
       
       <h3>Cotisations</h3>
       
       <table class="table table-sm table-striped">
          <thead>
            <tr>
              <th scope="col">Rubriques</th>
              <th scope="col">Base</th>
              <th scope="col">Taux Salarial</th>
              <th scope="col">Montant Salarial</th>
              <th scope="col">Taux Patronal</th>
              <th scope="col">Cot. patronales</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ b.resultatCRSM.listMontantParCotisationNonImposable }" var="item">
                <tr>
                    <td>${ item.cotisation.code } ${ item.cotisation.libelle }</td>
                    <td>${ b.resultatCRSM.salaireBrut }</td>
                    <td>${ item.cotisation.tauxSalarial }</td>
                    <td>${ item.montantSalarialParCotisation }</td>
                    <td>${ item.cotisation.tauxPatronal }</td>
                    <td>${ item.montantPatronaleParCotisation }</td>
                    
                </tr>
            </c:forEach>
            <tr>                                   
             <td><strong>Total Retenue</strong></td>
             <td></td>
             <td></td>
             <td><strong>${ b.resultatCRSM.totalRetenueSalarial }</strong></td>
             <td></td>
             <td><strong>${ b.resultatCRSM.totalCotisationsPatronales }</strong></td>
            </tr>          
          </tbody>
        </table>
  
  
       <h3>Net imposable : ${ b.resultatCRSM.netImposable }</h3>
       
       <table class="table table-sm table-striped">
          <thead>
            <tr>
              <th scope="col">Rubriques</th>
              <th scope="col">Base</th>
              <th scope="col">Taux Salarial</th>
              <th scope="col">Montant Salarial</th>
              <th scope="col">Taux Patronal</th>
              <th scope="col">Cot. patronales</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ b.resultatCRSM.listMontantParCotisationImposable }" var="item">
                <tr>
                    <td>${ item.cotisation.code } ${ item.cotisation.libelle }</td>
                    <td>${ b.resultatCRSM.salaireBrut }</td>
                    <td>${ item.cotisation.tauxSalarial }</td>
                    <td>${ item.montantSalarialParCotisation }</td>
                    <td>${ item.cotisation.tauxPatronal }</td>
                    <td>${ item.montantPatronaleParCotisation }</td>
                </tr>
            </c:forEach>
            <tr>                                   
             <td><strong>Total Retenue</strong></td>
             <td></td>
             <td></td>
             <td><strong>${ b.resultatCRSM.totalCotisationsImposable }</strong></td>
             <td></td>
             <td></td>
            </tr>          
          </tbody>
        </table>      
        <h3 class="float-right">Net à payer : ${ b.resultatCRSM.netAPayer }</h3>
        <br><br><br><br><br><br>
    </jsp:body>
</t:app>