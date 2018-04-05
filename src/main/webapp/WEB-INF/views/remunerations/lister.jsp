<jsp:include page="/WEB-INF/views/layouts/baseTop.jsp" />
<h1>Liste rémunérations employes</h1>
<a href="${ contextPath }/remunerations/creer"
	class="btn btn-outline-success">Creer</a>
<br />

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Date/heure création</th>
      <th scope="col">Période</th>
      <th scope="col">Matricule</th>
      <th scope="col">Salaire Brut</th>
      <th scope="col">Net Imposable</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
<c:forEach items="${ map }" var="e">
	<option value="${ e.key.id }">${ e.denomination }</option>
</c:forEach>
<jsp:include page="/WEB-INF/views/layouts/baseBottom.jsp" />
