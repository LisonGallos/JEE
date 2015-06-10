<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>Créer un performance</h1>

	<form:form method="POST" commandName="performance">

		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<spring:bind path="intitule">
					<td>Intitule :</td>
					<td><form:input path="intitule" /></td>
					<td><form:errors path="intitule" cssClass="error" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="points">
					<td>Points :</td>
					<td><form:input path="points" /></td>
					<td><form:errors path="points" cssClass="error" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="date_performance">
					<td>Date de la performance :</td>
					<td><form:input path="date_performance" /></td>
					<td><form:errors path="date_performance" cssClass="error" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="id_tmp">
					<td>Sélectionner une compétition :</td>
					<c:if test="${not empty competitionList}">
						<td><form:select path="id_tmp" items="${competitionList}"
								itemLabel="nom" valueLabel="ID" itemValue="ID" /></td>
					</c:if>
				</spring:bind>
			</tr>
			<tr>Créer un compétition
			</tr>
			<tr>
				<spring:bind path="competition.nom">
					<td>Nom :</td>
					<td><form:input path="competition.nom" /></td>
					<td><form:errors path="competition.nom" cssClass="error" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="competition.points">
					<td>Points :</td>
					<td><form:input path="competition.points" /></td>
					<td><form:errors path="competition.points" cssClass="error" /></td>
				</spring:bind>
			</tr>
		</table>
		<br />
		<br />
		<input type="submit" value="Valider" />

	</form:form>
	<br />
	<br />
	<tr>
		<a href="<c:url value="Accueil?membre=${command.ID}"/>">Accueil</a>
	</tr>
	<br />
	<br />
</body>
</html>
