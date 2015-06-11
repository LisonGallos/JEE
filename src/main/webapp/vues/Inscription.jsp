<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <body >
            <div class="container">
                <div class="page-header">
                    <h1>Inscription</h1>
                </div>
                <div id="sidebar" class="col-xs-6 col-sm-3 sidebar-offcanvas">
                    <div class="list-group">
                        <a class="list-group-item" href="
                            <c:url value="Index" />"> Index 
                        </a>
                        <a class="list-group-item" href="
                            <c:url value="Authentification" />"> Authentification 
                        </a>
                        <a class="list-group-item active" href="
                            <c:url value="Inscription" />"> Inscription 
                        </a>
                        <a class="list-group-item" href="
                            <c:url value="Accueil?membre=1" />"> Accueil visiteur 
                        </a>
                    </div>
                </div>
                <div style="float:left;width:300px;">
                    <div class="panel panel-primary" >
                        <div class="panel-heading"></div>
                        <div class="panel-body">
                            <form:form method="POST" commandName="membre">
                                <form:errors path="*" cssClass="errorblock" element="div" />
                                <table>
                                    <tr>
                                        <spring:bind path="nom">
                                            <td>
                                                <b>Nom  </b>
                                            </td>
                                            <td>
                                                <form:input path="nom" />
                                            </td>
                                            <td>
                                                <form:errors path="nom" cssClass="error" />
                                            </td>
                                        </spring:bind>
                                    </tr>
                                    <tr>
                                        <spring:bind path="prenom">
                                            <td>
                                                <b>Prenom  </b>
                                            </td>
                                            <td>
                                                <form:input path="prenom" />
                                            </td>
                                            <td>
                                                <form:errors path="prenom" cssClass="error" />
                                            </td>
                                        </spring:bind>
                                    </tr>
                                    <tr>
                                        <spring:bind path="email">
                                            <td>
                                                <b>Email  </b>
                                            </td>
                                            <td>
                                                <form:input path="email" />
                                            </td>
                                            <td>
                                                <form:errors path="email" cssClass="error" />
                                            </td>
                                        </spring:bind>
                                    </tr>
                                    <tr>
                                        <spring:bind path="id_tmp">
                                            <td>
                                                <b>Association  </b>
                                            </td>
                                            <c:if test="${not empty associationList}">
                                                <td>
                                                    <form:select path="id_tmp" items="${associationList}" itemLabel="nom" itemValue="ID" />
                                                </td>
                                            </c:if>
                                        </spring:bind>
                                    </tr>
                                    <tr>
                                        <spring:bind path="date_naissance_string">
                                            <td>
                                                <b>Date de naissance  </b>
                                            </td>
                                            <td>
                                                <form:input path="date_naissance_string" />
                                            </td>
                                            <td>
                                                <form:errors path="date_naissance_string" cssClass="error" />
                                            </td>
                                        </spring:bind>
                                    </tr>
                                </table>
                                <br/>
                                <br/>
                                <input type="submit" value="Valider" class="btn btn-default" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </html>
