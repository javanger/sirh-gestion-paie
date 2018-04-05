<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:app>
    <jsp:attribute name="header">
        <h1>Liste bulletins</h1>   
    </jsp:attribute>
    <jsp:body>
    <a href="${ contextPath }/bulletins/creer"
            class="btn btn-outline-success">Creer</a>
    <br />

   
    </jsp:body>
    <jsp:attribute name="footer"></jsp:attribute>
</t:app>