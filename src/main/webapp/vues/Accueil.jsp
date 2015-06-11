<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <head>
            <div class="container">
                <div class="page-header">
                    <h1>Accueil : ${command.nom} ${command.prenom}

                        <c:if test="${not empty command.message}">
                            <small>
                                <b>
                                    <br/>Message du référent : 
                                </b>${command.message}
                            </small>
                        </c:if>
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
                            <a class="list-group-item active" href="
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
                </div>
            </head>
        </html>