<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1>Sport - Association sportive - Compï¿½tition</h1>
<table>
	<tr>
		<a href="<c:url value="Authentification"/>">Authentification</a>
	</tr>
	<br />
	<br />
	<tr>
		<a href="<c:url value="Inscription"/>">Créer un compte</a>
	</tr>
	<br />
	<br />
	<tr>
		<a href="<c:url value="Accueil?membre=1"/>">Accueil visiteur</a>
	</tr>
</table>

</head>
</html>