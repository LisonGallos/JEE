<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="titre.Accueil" /> : ${personne}</title>
</head>
<body>
	<spring:message code="libelle.Accueil.lemonde" arguments="${personne}" />

	<c:forEach var="membre" items="${membreList}">
    	<option value="10"><c:out value="${membre.nom}" /></option>
	</c:forEach>

</body>
</html>