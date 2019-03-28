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
        Mein Konto
    </jsp:attribute>
        
    <%-- Stylesheet einbinden --%>
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
        <div class="container">
            <div>
                Benutzername:
                <span>${user.username}</span>
            </div>
            <div>
                Vorname:
                <span>${user.vorname}</span>
            </div>
            <div>
                Nachname:
                <span>${user.nachname}</span>
            </div>
             
    </jsp:attribute>
</template:base>