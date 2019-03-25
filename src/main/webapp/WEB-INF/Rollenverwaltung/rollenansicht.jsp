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
                <form method="post" class="stacked">´



                <%-- Eingabefelder --%>
                <label for="OWNER">Eigentümer:</label>
                <div class="side-by-side">
                    <input type="text" name="username" value="${task_form.values["OWNER"][0]}" readonly="OW">
                </div>
                
                 <label for="user_group">Nutzergruppe:</label>
                <div class="side-by-side">
                    <input type="text" name="user_group" value="${task_form.values["user_group"][0]}" readonly="readonly">
                </div>
                

                <div class="side-by-side">
                <label for="user_group">Adminrecht vergeben:</label>
                    <input type="checkbox" name="user_group" value="J">

                </div>
          
 
                </form>
        
           </jsp:attribute> 

</template:base>
