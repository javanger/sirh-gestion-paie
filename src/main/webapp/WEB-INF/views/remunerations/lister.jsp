<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>
	<jsp:attribute name="header">
	   <a href="${ path }/remunerations/creer"
			class="btn btn-outline-success float-rigth">Ajouter</a><br><br>
	   <h1>Liste des rémunérations</h1>
	</jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
	   <table class="table table-sm table-striped">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Date/Heure création</th>
		      <th scope="col">Matricule</th>
		      <th scope="col">Grade</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:if test="${ fn:length(map) > 0 }">
			    <c:forEach var="item" items="${ map }">		    
				    <tr>
				      <th scope="row">${ item.key.id }</th>
				      <td>${ item.value }</td>
				      <td>${ item.key.matricule }</td>
				      <td>${ item.key.grade.code }</td>
		   		    </tr>
    		    </c:forEach>
		     </c:if>
		  </tbody>
		</table>
    </jsp:body>
</t:app>