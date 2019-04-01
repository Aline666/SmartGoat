<%--
Erstellung eines Benuterkontos zur Verwaltung der eigenen Benutzerdaten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        <%-- Festlegen des Titels im Header --%>
        Benutzerdaten bearbeiten
    </jsp:attribute>

    <jsp:attribute name="head">
        <%-- Stylesheet einbinden --%>
        <link rel="stylesheet" href="<c:url value="/css/form.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <%-- Menü anpassen --%>
        <%-- Zurück zum Dashboard --%>
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>

        <%-- Zurück zum Profil --%>
        <div class="menuitem">
            <a href="<c:url value="/app/profil/"/>">Mein Konto</a>
        </div>
        
        <%-- Weiter zum Passwort ändern --%>
        <div class="menuitem">
            <a href="<c:url value="/app/profil/edit/pw/"/>">Passwort ändern</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <form method="post" class="stacked">
                <div class="column">
                    <%-- CSRF-Token --%>
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <%-- Eingabefelder --%>
                    <label for="profil_username">
                        Benutzername:
                    </label>
                    <input type="text" name="profil_username" value="${user.username}" readonly="readonly">

                    <label for="profil_vorname">
                        Vorname:
                        <span class="required">*</span>
                    </label>
                    <c:choose>
                        <c:when test="${empty profil_form}">
                            <input type="text" name="profil_vorname" value="${user.firstname}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="profil_vorname" value="${profil_form.values['profil_vorname'][0]}">
                        </c:otherwise>
                    </c:choose>
                            
                    <label for="profil_nachname">
                        Nachname:
                        <span class="required">*</span>
                    </label>
                    <c:choose>
                        <c:when test="${empty profil_form}">
                            <input type="text" name="profil_nachname" value="${user.lastname}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="profil_nachname" value="${profil_form.values['profil_nachname'][0]}">
                        </c:otherwise>
                    </c:choose>
                    
                    <button type="submit" name="action" value="save">speichern</button>
                </div>
                
                <%-- Fehlermeldungen --%>
                <c:if test="${!empty profil_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${profil_form.errors}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </c:if>
            </form>     
        </div>
    </jsp:attribute>
</template:base>