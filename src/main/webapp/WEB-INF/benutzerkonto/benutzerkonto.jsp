<%--
Erstellung eines Benuterkontos zur Verwaltung der eigenen Benutzerdaten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    
    <%-- Titel anlegen --%>
    <jsp:attribute name="title">
        Benutzerkonto
    </jsp:attribute>
    
    <%-- Stylesheet für Titel einbinden --%>
    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/task_edit.css"/>" />
    </jsp:attribute>
    
    <%-- Menütabs anlegen --%>
    <jsp:attribute name="menu">
        
        <%-- Menütab für Dashboard --%>
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>
        
        <%-- Menütab für Konto bearbeiten --%>
        <div class="menuitem">
            <a href="<c:url value="/app/Tierdashboard/species/"/>">Tierarten bearbeiten</a>
        </div>
    </jsp:attribute>
    
    <%-- Anlegen des Formulars --%>
    <jsp:attribute name="content">
        <form method="post" class="stacked">
            <div class="column">
                
                <%-- CSRF-Token für den Schutz des echten Benutzers --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">
                
                <%-- Eingabefeld Benutzername --%>
                <label for="task_owner">Benutzername:</label>
                <div class="side-by-side">
                    <input type="text" name="task_owner" value="${task_form.values["task_owner"][0]}" readonly="readonly">
                </div>
                
                <%-- Button zum Abschicken --%>
                <div class="side-by-side">
                    <button class="icon-pencil" type="submit" name="action" value="save">
                        Sichern
                    </button>
                </div>
            </div>
        </form>
    </jsp:attribute>
</template:base>