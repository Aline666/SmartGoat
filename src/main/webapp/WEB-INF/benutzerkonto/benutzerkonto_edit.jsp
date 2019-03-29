<%-- 
    Document   : benutzerkonto_edit
    Created on : Mar 29, 2019, 1:03:14 PM
    Author     : laurahetzel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        <c:choose>
            <c:when test="${edit}">
                Konto bearbeiten
            </c:when>
           
        </c:choose>
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/task_edit.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
      
        <div class="menuitem">
            <a href="<c:url value="/app/benutzerkonto/konto/"/>">Mein Konto</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <form method="post" class="stacked">
            <div class="column">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <%-- Eingabefelder --%>
                <label for="user_username">Benutzername: </label>
                <div class="side-by-side">
                    <input type="text" name="user_username" value="${user_form.values["user_username"][0]}">
                </div>


                <label for="user_firstname">Vorname: </label>
                
                <div class="side-by-side">
                    <input type="text" name="user_firstname" value="${user_form.values["user_firstname"][0]}">
                   
                </div>

                 
                    <label for="user_lastname">Nachname: </label>
                
                <div class="side-by-side">
                    <input type="text" name="user_lastname" value="${user_form.values["user_lastname"][0]}">
                   
                </div>
                    
                    
                    <label for="user_email">Email: </label>
                
                <div class="side-by-side">
                    <input type="text" name="user_email" value="${user_form.values["user_email"][0]}">
                   
                </div>

                    
                    
                    
                
                <%-- Button zum Abschicken --%>
                <div class="side-by-side">
                    <button class="icon-pencil" type="submit" name="action" value="save">
                        Sichern
                    </button>

                    <c:if test="${edit}">
                        <button class="icon-trash" type="submit" name="action" value="delete">
                            Löschen
                        </button>
                    </c:if>
                </div>
            </div>

            <%-- Fehlermeldungen --%>
            <c:if test="${!empty user_form.errors}">
                <ul class="errors">
                    <c:forEach items="${user_form.errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </form>
    </jsp:attribute>
</template:base>