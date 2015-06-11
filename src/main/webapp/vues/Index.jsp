<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <head>
            <div class="container">
                <div class="page-header">
                    <h1>Sport - Association sportive - Comp&eacute;tition</h1>
                </div>
                <div id="sidebar" class="col-xs-6 col-sm-3 sidebar-offcanvas">
                    <div class="list-group">
                        <a class="list-group-item active" href="
                            <c:url value="Index" />"> Index 
                        </a>
                        <a class="list-group-item" href="
                            <c:url value="Authentification" />"> Authentification 
                        </a>
                        <a class="list-group-item" href="
                            <c:url value="Inscription" />"> Inscription 
                        </a>
                        <a class="list-group-item" href="
                            <c:url value="Accueil?membre=1" />"> Accueil visiteur 
                        </a>
                    </div>
                </div>
            </div>
        </head>
    </html>