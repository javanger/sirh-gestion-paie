<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>
	<jsp:attribute name="header">
       <a href="${ path }/bulletins/creer"
			class="btn btn-outline-success">Ajouter</a>
       <h1>Liste des bulletins</h1>
    </jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
       <table class="table table-sm table-striped">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Date/Heure création</th>
              <th scope="col">Période</th>
              <th scope="col">Matricule</th>
              <th scope="col">Salaire brut</th>
              <th scope="col">Net imposable</th>
              <th scope="col">Net à payer</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
             <c:if test="${ fn:length(bulletins) > 0 }">
                <c:forEach var="item" items="${ bulletins }">         
	                    <tr>			                        
	    	    	    	<td>${ item.bulletinSalaire.id }</td>
	    	    	    	<td>${ item.dateCreation }</td>
	    	    	    	<td>${ item.periode }</td>
	    	    	    	<td>${ item.bulletinSalaire.remunerationEmploye.matricule }</td>
	    	    	    	<td>${ item.resultatCRSM.salaireBrut }</td>
	    	    	    	<td>${ item.resultatCRSM.netImposable }</td>	        	    	   
	    	    	    	<td>${ item.resultatCRSM.netAPayer }</td>	        	    	   
	                	  	<td><a href="${ path }/bulletins/${ item.bulletinSalaire.id }">Visualiser</a></td>
	                    </tr>
                </c:forEach>
             </c:if>
          </tbody>
        </table>
    </jsp:body>
</t:app>