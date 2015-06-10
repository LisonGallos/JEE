<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>Authentification</h1>


	<form:form method="POST" commandName="membre">

		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<spring:bind path="nom">
					<td>Nom :</td>
					<td><form:input path="nom" /></td>
					<td><form:errors path="nom" cssClass="error" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="password">
					<td>Password :</td>
					<td><form:input path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</spring:bind>
			</tr>
		</table>

		<input type="submit" value="Valider" />

	</form:form>
</body>
</html>
