<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <body>
            <div class="container">
                <div class="page-header">
                    <h1>Liste de membre à valider</h1>
                    <div style="float:right;width:auto;">
                        <a href="Index" target="_blank">
                            <input type="button"
	value="D&eacute;connexion" class="btn btn-default">
                            </a>
                        </div>
                    </div>
                    <div id="sidebar" class="col-xs-6 col-sm-3 sidebar-offcanvas">
                        <div class="list-group">
                            <a class="list-group-item" href="
                                <c:url value="Accueil?membre=${command.ID}" />"> Accueil 
                            </a>
                            <a class="list-group-item" href="
                                <c:url value="ClassementCompetition?membre=${command.ID}" />"> Classement par comp&eacute;tition 
                            </a>
                            <a class="list-group-item" href="
                                <c:url value="ClassementPerformance?membre=${command.ID}" />"> Meilleures performances 
                            </a>
                            <c:if test="${command.responsabilite.ID == 2 || command.responsabilite.ID == 3 || command.responsabilite.ID == 4 }">
                                <a class="list-group-item" href="
                                    <c:url value="CreerPerformance?membre=${command.ID}" />"> Cr&eacute;er une performance 
                                </a>
                            </c:if>
                            <c:if test="${command.responsabilite.ID == 3 || command.responsabilite.ID == 4 }">
                                <a class="list-group-item active" href="
                                    <c:url value="ListValideMembre?membre=${command.ID}" />"> Vaider des membres en attente 
                                </a>
                            </c:if>
                            <c:if test="${command.responsabilite.ID == 4 }">
                                <a class="list-group-item" href="
                                    <c:url value="AssigneReferent?membre=${command.ID}"/>"> Assigner les r&eacute;f&eacute;rents 
                                </a>
                            </c:if>
                        </div>
                    </div>
                    <div style="float:left;width:auto;">
                        <div class="panel panel-primary" >
                            <div class="panel-heading">
                                <b>Membre non validés</b>
                            </div>
                            <div class="panel-body">
                                <c:if test="${not empty membreList}">
                                    <c:forEach var="membre"
						items="${membreList}">
                                        <tr>
                                            <form:form method="POST" commandName="membre">
                                                <input type="hidden" name="action" />
                                                <form:errors path="*" cssClass="errorblock" element="div" />
                                                <table class="table">
                                                    <tr>
                                                        <td>
                                                            <b>Nom</b>
                                                        </td>
                                                        <td>
                                                            <b>Prenom</b>
                                                        </td>
                                                        <td>
                                                            <b>Email</b>
                                                        </td>
                                                        <td>
                                                            <b>Rôle</b>
                                                        </td>
                                                        <td>
                                                            <b>Statut</b>
                                                        </td>
                                                        <td>
                                                            <b>Message</b>
                                                        </td>
                                                        <c:if test="${membre.compte_valide.ID == 3}">
                                                            <tr  style="background-color: #d9edf7">
                                                            </c:if>
                                                            <c:if test="${membre.compte_valide.ID != 3}">
                                                                <tr>
                                                                </c:if>
                                                                <br />
                                                                <c:set var="IDconcat" scope="session"
												value="${command.ID}:${membre.ID}"></c:set>
                                                                <c:if test="${not empty membre.nom}">
                                                                    <a href="
                                                                        <c:url value="ValideMembre?membre=${IDconcat}"/>" target="_blank">
                                                                        <input type="button" value="Valider" class="btn btn-default" >
                                                                        </a>
                                                                        <td>${membre.nom}</td>
                                                                    </c:if>
                                                                    <c:if test="${not empty membre.prenom}">
                                                                        <td>${membre.prenom}</td>
                                                                    </c:if>
                                                                    <c:if test="${not empty membre.email}">
                                                                        <td>${membre.email}</td>
                                                                    </c:if>
                                                                    <c:if test="${not empty membre.responsabilite.role}">
                                                                        <td>${membre.responsabilite.role}</td>
                                                                    </c:if>
                                                                    <c:if test="${not empty membre.compte_valide.valide}">
                                                                        <td>${membre.compte_valide.valide}</td>
                                                                    </c:if>
                                                                    <c:if test="${not empty membre.message}">
                                                                        <td>${membre.message}</td>
                                                                    </c:if>
                                                                </tr>
                                                            </table>
                                                        </form:form>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </body>
                    </html>