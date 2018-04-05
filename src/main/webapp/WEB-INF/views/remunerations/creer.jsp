<jsp:include page="/WEB-INF/views/layouts/baseTop.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Créer Employe</h1>


<form method="post" action="${ contextPath }/remunerations">
	<div class="form-group">
		<label for="inputMatricule">Matricule</label> <input type="text"
			class="form-control" id="inputMatricule" name="inputMatricule" placeholder="Entez le matricule">
	</div>

	<div class="form-group">
		<label for="selectEntreprise">Entreprise</label> <select
			class="form-control" id="selectEntreprise" name="selectEntreprise">
			<c:forEach items="${ entreprises }" var="e">
				<option value="${ e.id }">${ e.denomination } </option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group">
		<label for="selectProfil">Profil</label> <select class="form-control"
			id="selectProfil" name="selectProfil">
			<c:forEach items="${ profils }" var="p">
				<option value="${ p.id }">${ p.code } </option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group">
		<label for="selectGrade">Grade</label> <select class="form-control"
			id="selectGrade" name="selectGrade">
			<c:forEach items="${ gradesEtCalculs }" var="g">
				<option value="${ g.key.id }">${ g.key.code } - ${ g.value } &euro; / an  </option>
			</c:forEach>
		</select>
	</div>


	<button type="submit" class="btn btn-primary">Ajouter</button>
</form>

<jsp:include page="/WEB-INF/views/layouts/baseBottom.jsp" />
