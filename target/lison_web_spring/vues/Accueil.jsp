<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<h1>Accueil : ${command.nom} ${command.prenom}</h1>

<c:if test="${not empty command.message}">
	<b></b>
	<p>Message du référent : ${command.message}</p>
	</b>
	<br />
	<br />
	<br />
	<br />
</c:if>

<table>
	<tr>
		<a href="<c:url value="Index"/>">Index</a>
	</tr>
	<br />
	<br />
	<tr>
		<a href="<c:url value="ClassementCompetition?membre=${command.ID}"/>">Classement
			par compétition</a>
	</tr>
	<br />
	<br />
	<tr>
		<a href="<c:url value="ClassementPerformance?membre=${command.ID}"/>">Meilleures
			performances</a>
	</tr>
	<br />
	<br />
	<c:if
		test="${command.responsabilite.ID == 2 || command.responsabilite.ID == 3 || command.responsabilite.ID == 4 }">
		<tr>
			<a href="<c:url value="CreerPerformance?membre=${command.ID}"/>">Créer
				une performance</a>
		</tr>
		<br />
		<br />
	</c:if>
	<c:if
		test="${command.responsabilite.ID == 3 || command.responsabilite.ID == 4 }">
		<tr>
			<a href="<c:url value="ListValideMembre?membre=${command.ID}"/>">Valider
				des membres en attente</a>
		</tr>
		<br />
		<br />
	</c:if>
	<c:if test="${command.responsabilite.ID == 4 }">
		<tr>
			<a href="<c:url value="AssigneReferent?membre=${command.ID}"/>">Assigner
				les référents</a>
		</tr>
		<br />
		<br />
	</c:if>
</table>

<a href="Index" target="_blank"> <input type="button"
	value="Déconnexion">
</a>


</head>
</html>