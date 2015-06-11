<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <body>
            <div class="container">
                <div class="page-header">
                    <h1>Validation</h1>
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
                                <a class="list-group-item" href="
                                    <c:url value="ListValideMembre?membre=${command.ID}" />"> Vaider des membres en attente 
                                </a>
                            </c:if>
                            <c:if test="${command.responsabilite.ID == 4 }">
                                <a class="list-group-item active" href="
                                    <c:url value="AssigneReferent?membre=${command.ID}"/>"> Assigner les r&eacute;f&eacute;rents 
                                </a>
                            </c:if>
                        </div>
                    </div>
                    <div style="float:left;width:auto;">
                        <div class="panel panel-primary" >
                            <div class="panel-heading"></div>
                            <div class="panel-body">
                                <form:form method="POST" commandName="membre">
                                    <input type="hidden" name="action" />
                                    <form:errors path="*" cssClass="errorblock" element="div" />
                                    <c:if test="${not empty membre}">
                                        <table class="table">
                                            <tr>
                                                <c:if test="${not empty membre.nom}">
                                                    <b>
                                                        <td>Nom</td>
                                                    </b>
                                                    <td>${membre.nom}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <c:if test="${not empty membre.prenom}">
                                                    <b>
                                                        <td>Prenom</td>
                                                    </b>
                                                    <td>${membre.prenom}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <c:if test="${not empty membre.email}">
                                                    <b>
                                                        <td>Email</td>
                                                    </b>
                                                    <td>${membre.email}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <c:if test="${not empty membre.responsabilite.role}">
                                                    <b>
                                                        <td>Responsabilité</td>
                                                    </b>
                                                    <td>${membre.responsabilite.role}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <c:if test="${not empty membre.date_inscription}">
                                                    <b>
                                                        <td>Date inscription</td>
                                                    </b>
                                                    <td>${membre.date_inscription}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <c:if test="${not empty membre.date_naissance}">
                                                    <b>
                                                        <td>Date naissance</td>
                                                    </b>
                                                    <td>${membre.date_naissance}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <c:if test="${not empty membre.association.nom}">
                                                    <b>
                                                        <td>Nom de l'association</td>
                                                    </b>
                                                    <td>${membre.association.nom}</td>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <spring:bind path="id_tmp">
                                                    <td>Validation :</td>
                                                    <c:if test="${not empty roleList}">
                                                        <td>
                                                            <form:select path="id_tmp" items="${roleList}"
									itemLabel="role" valueLabel="ID" itemValue="ID" />
                                                        </td>
                                                    </c:if>
                                                </spring:bind>
                                            </tr>
                                        </table>
                                    </c:if>
                                    <input type="submit" value="Valider" class="btn btn-default"  />
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </body>
        </html>

