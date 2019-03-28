<%-- 
    Document   : animal_list
    Created on : Mar 26, 2019, 4:12:42 PM
    Author     : laurahetzel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    
    <jsp:attribute name="title">
        Liste der Tiere
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
            <a href="<c:url value="/app/Tierdashboard/animal/new"/>">Tier anlegen</a>
        </div>

        <div class="menuitem">
            <a href="<c:url value="/app/Tierdashboard/species/"/>">Tierarten bearbeiten</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <link rel="stylesheet" href="<c:url value="/css/task_list.css"/>" />
        <%-- Suchfilter --%>
        <form method="GET" class="horizontal" id="search">
     

            <select name="search_species">
                <option value="">Alle Tierarten</option>

                <c:forEach items="${species}" var="species">
                    <option value="${species.id}" ${param.search_species == species.id ? 'selected' : ''}>
                        <c:out value="${species.name}" />
                    </option>
                </c:forEach>
            </select>

            <select name="search_status">
                <option value="">Alle Stati</option>

                <c:forEach items="${statuses}" var="status">
                    <option value="${status}" ${param.search_status == status ? 'selected' : ''}>
                        <c:out value="${status.label}"/>
                    </option>
                </c:forEach>
            </select>

            <button class="icon-search" type="submit" >
                Suchen
            </button>
        </form>

        <%-- Gefundene Aufgaben --%>
        <c:choose>
            
            <c:when test="${empty animals}">
                <p>
                    Es wurden keine Tiere gefunden. 🐈
                </p>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="utils" class="dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils"/>
                
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Tierart</th>
                            <th>Medizinische Informationen</th>
                            <th>Status</th>
                            <th>Eingangsdatum</th>
                        </tr>
                    </thead>
                    <c:forEach items="${animal}" var="animal">
                        <tr>
                            <td>
                                <a href="<c:url value="/app/Tierdashboard/animal/${animal.id}/"/>">
                                    <c:out value="${animal.animalname}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value="${animal.species.name}"/>
                            </td>
                            <td>
                                <c:out value="${animal.longText}"/>
                            </td>
                            <td>
                                <c:out value="${utils.formatDate(animal.dueDate)}"/>
                               
                            </td>
                            <td>
                                <c:out value="${animal.status.label}"/>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </jsp:attribute>
</template:base>
