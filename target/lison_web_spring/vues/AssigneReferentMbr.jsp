<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>Validation</h1>
	<form:form method="POST" commandName="membre">
		<input type="hidden" name="action" />

		<form:errors path="*" cssClass="errorblock" element="div" />

		<c:if test="${not empty membre}">

			<table>
				<tr>Membre à assigner
				</tr>
				<tr>
					<c:if test="${not empty membre.nom}">
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
				<tr>
					<spring:bind path="id_tmp">
						<td>Validation :</td>
						<c:if test="${not empty roleList}">
							<td><form:select path="id_tmp" items="${roleList}"
									itemLabel="role" valueLabel="ID" itemValue="ID" /></td>
						</c:if>
					</spring:bind>
				</tr>
			</table>
		</c:if>
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

