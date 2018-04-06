<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>
	<jsp:attribute name="header">
       <a href="${ path }/bulletins/creer"
			class="btn btn-outline-success">Ajouter</a>
		<div class="row">
			<div class="col-md-4 offset-md-4">Fleche</div>
		</div>
	       <h1>Bulletin de salaire</h1>
    </jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
       <c:if test="${ bulletins != null }">
       <table class="table table-sm table-striped">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Rubriques</th>
              <th scope="col">Base</th>
              <th scope="col">Taux Salarial</th>
              <th scope="col">Montant Salarial</th>
              <th scope="col">Taux Patronal</th>
              <th scope="col">Cot. patronales</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
              <tr>			                        
		   	    	<td>${ b.pediode.dateDebut }</td>
		   	    	<td>${ b.pediode.dateFin }</td>
              </tr>
          </tbody>
        </table>
        </c:if>
    </jsp:body>
</t:app>