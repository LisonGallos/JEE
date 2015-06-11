<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <head>
            <div class="container">
                <div class="page-header">
                    <h1>Classement par compétition</h1>
                    <div style="float:right;width:auto;">
                        <a href="Index" target="_blank">
                            <input type="button"
	value="Déconnexion" class="btn btn-default">
                            </a>
                        </div>
                    </div>
                    <div id="sidebar" class="col-xs-6 col-sm-3 sidebar-offcanvas">
                        <div class="list-group">
                            <a class="list-group-item" href="
                                <c:url value="Accueil?membre=${command.ID}" />"> Accueil 
                            </a>
                            <a class="list-group-item active" href="
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
                                <a class="list-group-item" href="
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
                                <c:if test="${not empty competitionReturn.nom}">
                                    <b>${competitionReturn.nom}</b>
                                </c:if>
                            </div>
                            <div class="panel-body">
                                <c:if test="${empty competitionReturn}">
                                    <c:if test="${not empty competitionList}">
                                        <form:form method="POST" commandName="compMembre">
                                            <form:errors path="*" cssClass="errorblock" element="div" />
                                            <table class="table">
                                                <spring:bind path="id_tmp">
                                                    <form:select path="id_tmp" items="${competitionList}"
						itemLabel="nom" valueLabel="ID" />
                                                </spring:bind>
                                            </table>
                                            <input value="Valider" type="submit" class="btn btn-default">
                                            </form:form>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${not empty regionlist}">
                                        <c:if test="${empty Laregion}">
                                            <form:form method="POST" commandName="compMembre">
                                                <table class="table">
                                                    <spring:bind path="id_tmp">
                                                        <form:select path="id_tmp" items="${regionlist}"
						itemLabel="membre.association.region" valueLabel="ID"
						itemValue="ID" />
                                                    </spring:bind>
                                                </table>
                                                <input value="Valider" type="submit" class="btn btn-default">
                                                </form:form>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${not empty performanceList}">
                                            <table class="table">
                                                <tr>
                                                    <td>
                                                        <b>Nom</b>
                                                    </td>
                                                    <td>
                                                        <b>Pr&eacute;nom</b>
                                                    </td>
                                                    <td>
                                                        <b>Points</b>
                                                    </td>
                                                    <td>
                                                        <b>Association</b>
                                                    </td>
                                                    <td>
                                                        <b>R&eacute;gion</b>
                                                    </td>
                                                </tr>
                                                <c:forEach var="perf" items="${performanceList}">
                                                    <tr>
                                                        <td>${perf.membre.nom}</td>
                                                        <td>${perf.membre.prenom}</td>
                                                        <td>${perf.points}</td>
                                                        <td>${perf.membre.association.nom}</td>
                                                        <td>${perf.membre.association.region}</td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </head>
                </html>