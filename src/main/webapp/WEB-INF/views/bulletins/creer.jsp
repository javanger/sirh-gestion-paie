<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>

	<jsp:attribute name="header">
	<h1>Créer Bulletin</h1>
    </jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>

	<jsp:body>
	
		<form:form method="post">
		      <form:select path="profils"></form:select>
				<td><form:input path="model.matricule" /></td>
		</form:form>


</jsp:body>
</t:app>