<%-- 
    Document   : details
    Created on : 23.03.2019, 14:02:47
    Author     : Nasi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">Details</jsp:attribute>

    <jsp:attribute name="main">
        
        <%-- Button zur Navigation zur Übersicht --%>
        <form method="GET" action="<c:url value="/"/>">
            <button type="submit">
                Zurück zur Übersicht
            </button>
        </form>
            
        <%-- Inhalte des anzulegenden Tieres --%>
        <div class="container">
            <form method="POST">
                <input name="anzulegendesTier" type="hidden" value="4"/>
                
                <div class="formline">
                    <div>
                        <label for="typ">Typ</label>
                        <br/>
                        <input name="typ" type="text" value="${tier.typ}" />
                    </div>
                    <div>
                        <label for="rasse">Rasse</label>
                        <br/>
                        <input name="rasse" type="text" value="${tier.rasse}" />
                    </div>
                    <div>
                        <label for="name">Name</label>
                        <br/>
                        <input name="name" type="text" value="${tier.name}" />
                    </div>
                    <div>
                        <label for="farbe">Farbe</label>
                        <br/>
                        <input name="farbe" type="text" value="${tier.farbe}" />
                    </div>
                </div> 
                    
                <%-- Button zum Speichern --%>
                <div class="formline">
                    <button type="submit">Tier speichern</button>
                </div>
            </form>
        </div>
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
