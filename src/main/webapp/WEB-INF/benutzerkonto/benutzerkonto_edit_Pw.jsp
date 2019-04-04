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
         Benutzerpasswort ändern
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
        
        <%-- Zurück zum Konto bearbeiten --%>
        <div class="menuitem">
            <a href="<c:url value="/app/profil/edit/"/>">Profil bearbeiten</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <form method="post" class="stacked">
                <div class="column">
                    <%-- CSRF-Token --%>
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <%-- Eingabefelder --%>
                    <label for="pw_old">
                        Aktuelles Passwort:
                        <span class="required">*</span>
                    </label>
                    <input type="password" name="pw_old">

                    <label for="pw_new1">
                        Neues Passwort:
                        <span class="required">*</span>
                    </label>
                    <input type="password" name="pw_new1">
                    
                    <label for="pw_new2">
                        Neues Passwort wiederholen
                        <span class="required">*</span>
                    </label>
                    <input type="password" name="pw_new2">

                    <%-- Speichern-Button --%>
                    <button type="submit" name="action" value="save">Änderung speichern</button>
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