<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<h1>Classement par compétition</h1>

<c:if test="${empty competitionReturn}">
	<c:if test="${not empty competitionList}">
		<form:form method="POST" commandName="compMembre">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>

				<spring:bind path="id_tmp">
					<form:select path="id_tmp" items="${competitionList}"
						itemLabel="nom" valueLabel="ID" />
				</spring:bind>
			</table>
			<input value="Submit" type="submit">
		</form:form>
	</c:if>
</c:if>

<c:if test="${not empty regionlist}">
	<c:if test="${empty Laregion}">
		<form:form method="POST" commandName="compMembre">
			<table>
				<spring:bind path="id_tmp">
					<form:select path="id_tmp" items="${regionlist}"
						itemLabel="membre.association.region" valueLabel="ID"
						itemValue="ID" />
				</spring:bind>
			</table>
			<input value="Submit" type="submit">
		</form:form>
	</c:if>
</c:if>

<c:if test="${not empty performanceList}">
	<table>
		<tr>
			<td>Nom</td>
			<td>Prénom</td>
			<td>Points</td>
		</tr>
		<c:forEach var="perf" items="${performanceList}">

			<tr>
				<td>${perf.membre.nom}</td>
				<td>${perf.membre.prenom}</td>
				<td>${perf.points}</td>
			</tr>
			<br />
			<br />
	</table>
	</c:forEach>
</c:if>
<br />
<br />
<tr>
	<a href="<c:url value="Accueil?membre=${command.ID}"/>">Accueil</a>
</tr>
<br />
<br />
</head>
</html>