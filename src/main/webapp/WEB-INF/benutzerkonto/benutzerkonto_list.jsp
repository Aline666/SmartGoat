<%--
Erstellung eines Benuterkontos zur Verwaltung der eigenen Benutzerdaten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Benutzerdaten anzeigen
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/form.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/tasks/list/"/>">Liste der Aufgaben</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/tasks/categories/"/>">Kategorien bearbeiten</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <div>
                Benutzername:
                <span>${user.username}</span>
            </div>
            <div>
                Vorname:
                <span>${user.firstname}</span>
            </div>
            <div>
                Nachname:
                <span>${user.lastname}</span>
            </div>
             
            
            
            <a href="<c:url value="/app/profil/edit/"/>" class="greenBtn">Benutzerdaten ändern</a>  
            <a href="<c:url value="/app/profil/edit/pw/"/>" class="greenBtn">Passwort ändern</a>  
        </div>
    </jsp:attribute>
</template:base>