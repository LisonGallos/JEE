<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
 <h1>Inscription</h1>
 
<title>${personne}</title>

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
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Responsabilite :</td>
				<td><form:input path="responsabilite" /></td>
				<td><form:errors path="responsabilite" cssClass="error" /></td>
			</tr>		
			<tr>
				<td>Date de naissance :</td>
				<td><form:input path="date_naissance" /></td>
				<td><form:errors path="date_naissance" cssClass="error" /></td>
			</tr>
		</table>
	
		<input type="submit" value="Valider" />
	
	</form:form>
</body>
</html>
