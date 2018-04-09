<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" scope="application"
	value="${ pageContext.request.contextPath }/mvc"></c:set>

<ul class="nav">
	<li class="nav-item"><a class="nav-link"
		href="${ path }/remunerations">Accueil</a></li>
	<li class="nav-item"><a class="nav-link"
		href="${ path }/remunerations">Rémunérations</a></li>
	<li class="nav-item"><a class="nav-link"
		href="${ path }/bulletins">Bulletins</a></li>
</ul>