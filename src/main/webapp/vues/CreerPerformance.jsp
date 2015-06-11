<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <body>
            <div class="container">
                <div class="page-header">
                    <h1>Cr&eacute;er une performance</h1>
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
                                <a class="list-group-item active" href="
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
                    <div style="float:left;width:400px;">
                        <div class="panel panel-primary" >
                            <div class="panel-heading"></div>
                            <div class="panel-body">
                                <form:form method="POST" commandName="performance">
                                    <form:errors path="*" cssClass="errorblock" element="div" />
                                    <table >
                                        <tr>
                                            <spring:bind path="intitule">
                                                <td>Intitule </td>
                                                <td>
                                                    <form:input path="intitule" />
                                                </td>
                                                <td>
                                                    <form:errors path="intitule" cssClass="error" />
                                                </td>
                                            </spring:bind>
                                        </tr>
                                        <tr>
                                            <spring:bind path="points">
                                                <td>Points </td>
                                                <td>
                                                    <form:input path="points" />
                                                </td>
                                                <td>
                                                    <form:errors path="points" cssClass="error" />
                                                </td>
                                            </spring:bind>
                                        </tr>
                                        <tr>
                                            <spring:bind path="date_performance_string">
                                                <td>Date de la performance </td>
                                                <td>
                                                    <form:input path="date_performance_string" />
                                                </td>
                                                <td>
                                                    <form:errors path="date_performance_string" cssClass="error" />
                                                </td>
                                            </spring:bind>
                                        </tr>
                                        <tr>
                                            <spring:bind path="id_tmp">
                                                <tr>
                                                    <td></td>
                                                    <td>
                                                        <b>Sélectionner une compétition </b>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <c:if test="${not empty competitionList}">
                                                        <td>
                                                            <form:select path="id_tmp" items="${competitionList}"
								itemLabel="nom" itemValue="ID" />
                                                        </td>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </spring:bind>
                                    </tr>
                                    <tr>
                                        <spring:bind path="competition.nom">
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <b>
                                                        <p>OU</p>
                                                    </b>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <b>Créer une compétition</b>
                                                </td>
                                            </tr>
                                            <td>Nom </td>
                                            <td>
                                                <form:input path="competition.nom" />
                                            </td>
                                            <td>
                                                <form:errors path="competition.nom" cssClass="error" />
                                            </td>
                                        </spring:bind>
                                    </tr>
                                    <tr>
                                        <spring:bind path="competition.points">
                                            <td>Points </td>
                                            <td>
                                                <form:input path="competition.points" />
                                            </td>
                                            <td>
                                                <form:errors path="competition.points" cssClass="error" />
                                            </td>
                                        </spring:bind>
                                    </tr>
                                </table>
                                <br />
                                <br />
                                <input type="submit" value="Valider" class="btn btn-default"  />
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </html>
