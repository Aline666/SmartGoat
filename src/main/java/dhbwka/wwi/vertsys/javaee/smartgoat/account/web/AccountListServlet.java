/* Servlet für die Auflistung der Kontodetails */

package dhbwka.wwi.vertsys.javaee.smartgoat.account.web;

import dhbwka.wwi.vertsys.javaee.smartgoat.account.ejb.AccountBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.account.jpa.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/app/benutzerkonto/konto/"})
public class AccountListServlet extends HttpServlet {

    @EJB
    private AccountBean accountBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        // Alle vorhandenen Einträge aus der Datenbank lesen und im Request
        // Context ablegen, damit sie in der JSP zur Verfügung stehen
        List<Account> entries = this.accountBean.findAllEntries();
        request.setAttribute("entries", entries);

         // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/benutzerkonto/benutzerkonto_list.jsp");
        dispatcher.forward(request, response);
        
        // In der Session liegende Fehlermeldung verwerfen, damit wir beim
        // nächsten Aufruf wieder mit einem leeren Eingabefeld anfangen
        HttpSession session = request.getSession();
        session.removeAttribute("fehler");
        session.removeAttribute("name");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Prüfen, ob der Anwender seinen Namen eingegeben hat
        HttpSession session = request.getSession();

        String fehler = "";
        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            fehler = "Bitte gib erst deinen Namen ein.";
            session.setAttribute("fehler", fehler);
            session.setAttribute("name", name);
        }

        // Neuen Eintrag speichern
        if (fehler.isEmpty()) {
            this.accountBean.createNewEntry(name);
        }

        // Browser auffordern, die Seite neuzuladen
        response.sendRedirect(request.getContextPath());
    }

}
