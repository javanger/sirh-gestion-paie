<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:app>
	<jsp:attribute name="header">
	<h1>Gestion Paie</h1>
    </jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
		<h3>Connexion</h3>
		<!-- Spring Security s'attend aux paramètres "username" et "password" -->
		 
		<form method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Username</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nom d'utilisateur"
							name="username">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" class="form-control"
							id="exampleInputPassword1" placeholder="Password" name="password">
		  </div>

		  <sec:csrfInput/>
		  <button type="submit" class="btn btn-primary">Se connecter</button>
		</form>

		<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
		<c:if test="${param.error !=null}">
			Erreur d'authentification
		</c:if>
	</jsp:body>
</t:app>