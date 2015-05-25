<%@page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Accueil : ${personne}</title>

<h1>Inscription</h1>

<form:form method="POST" commandName="membre">

	<form:errors path="*" cssClass="errorblock" element="div" />

	<table>
		<tr>
			<td>Nom :</td>
			<td><form:input path="nom" /></td>
			<td><form:errors path="nom" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Prenom :</td>
			<td><form:input path="prenom" /></td>
			<td><form:errors path="prenom" cssClass="error" /></td>
		</tr>
	</table>

	<input type="submit" value="Valider" />

</form:form>

<c:if test="${not empty membreList}">
	<c:forEach var="membreA" items="${membreList}">
		<li>${membreA.nom} : ${membreA.association.nom}</li>
	</c:forEach>
</c:if>

</head>
</html>