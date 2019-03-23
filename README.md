Anwendung "SmartGoat"
=========================

Kurzbeschreibung
----------------

Bei „Smartgoat“ handelt es sich um eine serverseitige MVC (Model, View, Controller) Anwendung, die in der Programmiersprache Java realisiert wurde. 
Durch die Nutzung der Jakarta Enterprise Edition läuft die Anwendung auf einem Applikationsserver. Durch die Nutzung von Jakarta EE erhalten wir gleichzeitig eine Anwendungsorientierte Middleware Spezifikation, die uns zusätzliche Funktionen wie eine Benutzer-/Rechteverwaltung oder Datenbankzugriffsfunktionen bietet. Die Jakarta Enterprise Edition ist insbesondere für Java-, sowie Webanwendungen zu nutzen und daher für unser Projekt bestens geeignet.
Durch die rein serverseitige Anwendung wird die Anwendungslogik und der HTML-Code rein serverseitig generiert und im Browser dargestellt.
Die Schnittstelle für den Webservice wird mit Hilfe SOAP erstellt und bietet eine Schnittstelle für den Zugriff auf die Tierübersicht.


Verwendete Technologien
-----------------------

Unsere Anwendung benutzt Maven zum Builden, sowie zur Rechteverwaltung.
Der Quellcode ist folgendermaßen:

Servlets: fungieren beim MVC-Konzept als Controller und vermitteln zwischen dem Model und View, sie empfangen sämtliche http-Anfragen

EJB: stellen beim MVC Konzept das Model dar und kapseln die Fachliche Anwendungslogik

Persistence Entities:  helfen uns bei der Erstellung von Datenbanktabellen und unterstützen beim Zugriff auf die Datenbank.

JSP: stehen für die View beim MVC-Modell und sorgen für die Darstellung des Codes.

Programme:
-----------------------

Netbeans: Als Entwicklungsumgebung

Github: Als Versionsverwaltung für den Code

TomEE: Als Applikationsserver

Derby: Als SQL Datenbank

SOAP: für die Webservice Schnittstelle


Screenshots
-----------


Copyright
---------

© 2019 Laura Hetzel, Nastasia Lindemann, Aline Schaub <br/>

E-Mail: [aline.schaub@web.de](mailto:aline.schaub@web.de) <br/>
Github Repository: https://github.com/Aline666/Smartgoat

