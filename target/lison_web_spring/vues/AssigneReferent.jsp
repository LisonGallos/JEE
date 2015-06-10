<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<h1>Assigner un référent</h1>

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

<c:if test="${not empty associationList}">
	<form:form method="POST" commandName="membre">
		<table>
			<form:errors path="*" cssClass="errorblock" element="div" />
			<spring:bind path="id_tmp">
				<form:select path="id_tmp" items="${associationList}"
					itemLabel="nom" valueLabel="ID" />
			</spring:bind>
		</table>
		<input value="Submit" type="submit">
	</form:form>
</c:if>

<c:if test="${not empty membreList}">
	<c:forEach var="membre" items="${membreList}">
		<tr>
			<c:set var="IDconcat" scope="session"
				value="${command.ID}:${membre.ID}"></c:set>
			<c:if test="${not empty membre.nom}">
				<a href="<c:url value="AssigneReferentMbr?membre=${IDconcat}"/>">ASSIGNER</a>
				<b></b>
				<td>Nom</td>
				</b>
				<td>${membre.nom}</td>
			</c:if>
			<c:if test="${not empty membre.prenom}">
				<b><td>Prenom</td></b>
				<td>${membre.prenom}</td>
			</c:if>
			<c:if test="${not empty membre.email}">
				<b><td>Email</td></b>
				<td>${membre.email}</td>
			</c:if>
			<c:if test="${not empty membre.responsabilite}">
				<b><td>Responsabilité</td></b>
				<td>${membre.responsabilite}</td>
			</c:if>
			<c:if test="${not empty membre.date_inscription}">
				<b><td>Date inscription</td></b>
				<td>${membre.date_inscription}</td>
			</c:if>
			<c:if test="${not empty membre.date_naissance}">
				<b><td>Date naissance</td></b>
				<td>${membre.date_naissance}</td>
			</c:if>
			<c:if test="${not empty membre.association.nom}">
				<b><td>Nom de l'association</td></b>
				<td>${membre.association.nom}</td>
			</c:if>
		</tr>
		<br />
		<br />
	</c:forEach>
</c:if>

</table>
<br />
<br />
<tr>
	<a href="<c:url value="Accueil?membre=${command.ID}"/>">Accueil</a>
</tr>
<br />
<br />
</head>
</html>