<%-- 
    Document   : rollenansicht
    Created on : 24.03.2019, 13:08:19
    Author     : a.schaub
--%>
<%-- 
    Document   : rollenansicht
    Created on : 24.03.2019, 13:08:19
    Author     : a.schaub
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setAttribute("isAdmin", request.isUserInRole("admin")); %>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>

    <jsp:attribute name="title">
        Dashboard
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/tasks/list/"/>">Liste der Aufgaben</a>
        </div>

             <div class="menuitem">
            <a href="<c:url value="/app/tasks/task/new/"/>">Aufgabe anlegen</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/tasks/categories/"/>">Tierkategorien bearbeiten</a>
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
                            <th>Nutzername:</th>
                            <th>Aktuelle Berrechtigung</th>
                            <th>Adminrecht vergeben</th>
                        </tr>
                    </thead>
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <td>                              
                                 <c:out value="${roles.username}"/>
                                </a>
                            </td>
                            
                            <td>
                                <c:out value="${roles.groupname}"/>
                            </td>
                            <td>
                                <div>
                                  <input type="checkbox" name="user_group" value="J">
                                </div>
                            </td>

                        </tr>
                    </c:forEach>
                </table>
    </jsp:attribute>
</template:base>