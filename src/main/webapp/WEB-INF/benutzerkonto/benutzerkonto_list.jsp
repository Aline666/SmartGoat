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
        Benutzerdaten anzeigen
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

        <%-- Weiter zum Konto bearbeiten --%>
        <div class="menuitem">
            <a href="<c:url value="/app/profil/edit/"/>">Profil bearbeiten</a>
        </div>
        
        <%-- Weiter zum Passwort ändern --%>
        <div class="menuitem">
            <a href="<c:url value="/app/profil/edit/pw/"/>">Passwort ändern</a>
        </div>
    </jsp:attribute>


    <jsp:attribute name="content">
        <table>
            <tr>
                <td>
                    <div class="container">
                        <div>
                            Benutzername:
                            <span>${user.username}</span>
                        </div>
                    </div>
                </td>
            </tr>
            
            <tr>
                <td>
                    <div>
                        Vorname:
                        <span>${user.firstname}</span>
                    </div>     
                </td>
            </tr>
    
            <tr>
                <td>
                    <div>
                        Nachname:
                        <span>${user.lastname}</span>
                    </div>
                </td>  
            </tr>
            
            <tr>
                <td>
                    <div>
                        E-Mail Adresse:
                        <span>${user.email}</span>
                    </div>
                </td>  
            </tr>
        </table>
    </jsp:attribute>
</template:base>