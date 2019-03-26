<%-- 
    Document   : animal_edit
    Created on : Mar 26, 2019, 4:51:53 PM
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
                Tier bearbeiten
            </c:when>
            <c:otherwise>
                Tier anlegen
            </c:otherwise>
        </c:choose>
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/task_edit.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/Tierdashboard/list/"/>">Tierdashboard</a>
        </div>
        
        <div class="menuitem">
            <a href="<c:url value="/app/Tierdashboard/list/"/>">Liste</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <form method="post" class="stacked">
            <div class="column">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <%-- Eingabefelder --%>
                <label for="animal_name">Tiername:</label>
                <div class="side-by-side">
                    <input type="text" name="animal_name" value="${animal_form.values["animal_name"][0]}" >
                </div>

                <label for="animal_species">Tierart:</label>
                <div class="side-by-side">
                    <select name="animal_species">
                        <option value="">Keine Tierart</option>

                        <c:forEach items="${species}" var="species">
                            <option value="${species.id}" ${animal_form.values["animal_cspecies"][0] == species.id.toString() ? 'selected' : ''}>
                                <c:out value="${species.name}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <label for="animal_due_date">
                    Eingangsdatum:
                    <span class="required">*</span>
                </label>
                <div class="side-by-side">
                    <input type="text" name="animal_due_date" value="${animal_form.values["animaldue_date"][0]}">
                   
                </div>

                <label for="animal_status">
                    Status:
                    <span class="required">*</span>
                </label>
                <div class="side-by-side margin">
                    <select name="animal_status">
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status}" ${animal_form.values["animal_status"][0] == status ? 'selected' : ''}>
                                <c:out value="${status.label}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <label for="animal_long_text">
                    Medizinische Informationen:
                </label>
                <div class="side-by-side">
                    <textarea name="animal_long_text"><c:out value="${animal_form.values['animal_long_text'][0]}"/></textarea>
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
            <c:if test="${!empty animal_form.errors}">
                <ul class="errors">
                    <c:forEach items="${animal_form.errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </form>
    </jsp:attribute>
</template:base>