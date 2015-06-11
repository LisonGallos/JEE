<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <body>
            <div class="container">
                <div class="page-header">
                    <h2>Votre demande d'inscription ${association} a été soumise</h2>
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
                </div>
            </body>
        </html>
