<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>
	<jsp:attribute name="header">
	<h1>Créer Bulletin</h1>
    </jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
		<form:form method="post" modelAttribute="bulletin">

			<div class="form-group">
				<label for="selectProfil">Période</label>
			    <form:select path="periode.id" items="${periodes}" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="matricule">Matricule</label>
			    <form:select path="remunerationEmploye.id" items="${employes}" itemLabel="matricule" itemValue="id" id="matricule" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="primeExceptionnelle">Prime Exceptionnelle</label>
			    <form:input path="primeExceptionnelle" id="primeExceptionnelle" cssClass="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary">Ajouter</button>
			
		</form:form>
</jsp:body>
</t:app>