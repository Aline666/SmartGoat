<%--
Erstellung eines Benuterkontos zur Verwaltung der eigenen Benutzerdaten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    
    <jsp:attribute name="title">
       Deine Daten
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" />
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/Tierdashboard/species/"/>">Konto bearbeiten</a>
        </div>
    </jsp:attribute>

   <jsp:attribute name="content">
        <link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" />
       
        <%-- Gefundene Aufgaben --%>
        <c:choose>
            
            <c:when test="${empty user}">
                <p>
                   Irgendwas ist schiefgelaufen. 🐈
                </p>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="utils" class="dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils"/>
                
                <table>
                    <thead>
                        <tr>
                            <th>Benutzername</th>
                            <th>Vorname</th>
                            <th>Nachname</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <c:forEach items="${user}" var="user">
                        <tr>
                            <td>
                                <a href="<c:url value="/app/benutzerkonto/konto/${user.username}/"/>">
                                    <c:out value="${user.username}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value="${user.firstname}"/>
                            </td>
                            <td>
                                <c:out value="${user.lastname}"/>
                            </td>
                            <td>
                                <c:out value="${user.email}"/>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </jsp:attribute>
</template:base>