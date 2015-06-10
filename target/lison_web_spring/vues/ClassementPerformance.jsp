<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1>Classement par Région des meilleures performances</h1>


<table>
	<c:forEach var="regionA" items="${regionlist}">
		<tr>
			<td><b><u></br>${regionA}</u></b> <c:if
					test="${not empty meilleurePerf}">
					<c:forEach var="perf" items="${meilleurePerf}">
						<%-- 				<c:forEach var="membreA" items="${membreList}"> --%>
						<%-- 					<c:if test="${membreA.ID == perf.id_membre }"> --%>
						<c:if test="${regionA == perf.membre.association.region}">
							<tr>
								<td>${perf.membre.nom}</td>
								<td>${perf.membre.prenom}</td>
								<td>${perf.points}</td>
							</tr>
						</c:if>
						<%-- 					</c:if> --%>
						<%-- 				</c:forEach> --%>
					</c:forEach>
				</c:if></td>
		</tr>
	</c:forEach>
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