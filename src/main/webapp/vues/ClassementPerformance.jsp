<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <head>
            <div class="container">
                <div class="page-header">
                    <h1>Classement par R&eacute;gion 
                        <small>meilleures performances</small>
                    </h1>
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
                            <a class="list-group-item active" href="
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
                    <div style="float:left;width:500px;">
                        <div class="panel panel-primary" >
                            <div class="panel-heading"></div>
                            <div class="panel-body">
                                <table class="table">
                                    <c:forEach var="regionA" items="${regionlist}">
                                        <tr>
                                            <td>
                                                <b>
                                                    <u>
                                                    </br>${regionA}
                                                </u>
                                            </b>
                                            <c:if
					test="${not empty meilleurePerf}">
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
                                                        <b>Date de la performance</b>
                                                    </td>
                                                </tr>
                                                <c:forEach var="perf" items="${meilleurePerf}">
                                                    <c:if test="${regionA == perf.membre.association.region}">
                                                        <tr>
                                                            <td>${perf.membre.nom}</td>
                                                            <td>${perf.membre.prenom}</td>
                                                            <td>${perf.points}</td>
                                                            <td>${perf.date_performance}</td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </head>
    </html>