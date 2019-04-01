
<%-- 
    Document   : rollenansicht
    Created on : 24.03.2019, 13:08:19
    Author     : a.schaub
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>

    <jsp:attribute name="title">
        Rollenverwaltung
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>

        <c:if test="${requestScope.isAdmin}">
            <div class="menuitem">
                <a href="<c:url value="/app/rollenVerwaltung/"/>">Rollenverwaltung</a>
            </div>
        </c:if>
    </jsp:attribute>


    <jsp:attribute name="content">
        <link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" />

        <jsp:useBean id="utils" class="dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils"/>

        <table>
            <thead>
                <tr>
                    <th>Nutzername</th>
                    <th>Aktuelle Berechtigung</th>
                    <th>Adminrecht vergeben</th>
                    <th>Adminrecht entziehen</th>
                </tr>
            </thead>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>                              
                        <c:out value="${user.username}"/>
                        </a>
                    </td>

                    <td>
                        <c:forEach items="${user.groups}" var="group">
                            <c:out value="${group}"/>
                        </c:forEach>
                    </td>

                    <td>
                        <div>
                            <form method="POST">
                                <%-- CSRF-Token --%>
                                <input type="hidden" name="csrf_token" value="${csrf_token}">
                                
                                <%-- Username und Aktion --%>
                                <input type="hidden" name="username" value="<c:out value="${user.username}"/> "/>
                                <button type="submit" name="action" value="set-admin">Adminrechte geben</button>
                            </form>
                        </div>
                    </td>

                    <td>
                        <div>
                            <form method="POST">
                                <%-- CSRF-Token --%>
                                <input type="hidden" name="csrf_token" value="${csrf_token}">
                                
                                <%-- Username und Aktion --%>
                                <input type="hidden" name="username" value="<c:out value="${user.username}"/> "/>
                                <button type="submit" name="action" value="unset-admin">Adminrechte entziehen</button>
                            </form>
                        </div>
                    </td>

                </tr>
            </c:forEach>
        </table>

        <ul class="error">
            <c:forEach items="${errorMessages}" var="message">
                <li><c:out value="${message}"/></li>
                </c:forEach>
        </ul>
    </jsp:attribute>
</template:base>