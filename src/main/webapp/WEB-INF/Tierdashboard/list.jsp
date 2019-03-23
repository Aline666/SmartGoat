<%-- 
    Document   : Tierdashboard
    Created on : Mar 23, 2019, 11:42:11 AM
    Author     : laurahetzel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">Tierübersicht</jsp:attribute>
    <jsp:attribute name="main">
        
        <%-- Button zum Anlegen eines neuen Tieres --%>
        <form method="GET" action="<c:url value="/new/"/>">
            <button type="submit">
                Neues Tier anlegen
            </button>
        </form>
            
        <%-- Liste der bereits vorhandenen Tiere --%>
        <table class="container">
            <c:if test="${not empty tiere}">
                <thead>
                    <tr>
                        <th>
                            Typ
                        </th>
                        <th>
                            Rasse
                        </th>
                        <th>
                            Name
                        </th>
                        <th>
                            Farbe
                        </th>
                    </tr>
                </thead>
            </c:if>
        
            <c:forEach items="${tiere}" var="tier">
                <tr>
                    <td>
                        <a href="<c:url value="/show/${tier.id}"/>">
                            <c:out value="${tier.typ}"/>
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value="/show/${tier.id}"/>">
                            <c:out value="${tier.rasse}"/>
                        </a>
                    </td>
                    <td>
                        <c:out value="${tier.name}"/>
                    </td>
                    <td>
                        <c:out value="${tier.farbe}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </jsp:attribute>
</template:base>
    
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html> --%>
