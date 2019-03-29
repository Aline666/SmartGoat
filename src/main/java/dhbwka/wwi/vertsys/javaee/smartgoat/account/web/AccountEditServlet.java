
package dhbwka.wwi.vertsys.javaee.smartgoat.account.web;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author laurahetzel
 */

@WebServlet(urlPatterns = "/app/benutzerkonto/edit/*")
public class AccountEditServlet extends HttpServlet{
    
    
/**
 * Seite zum Anlegen oder Bearbeiten einer Aufgabe.
 */


    @EJB
    UserBean userBean;

    @EJB
    ValidationBean validationBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     

        // Zu bearbeitende Aufgabe einlesen
        HttpSession session = request.getSession();

        User user = this.getRequestedUser(request);
        request.setAttribute("edit", user != null);
                                
        if (session.getAttribute("user_form") == null) {
            // Keine Formulardaten mit fehlerhaften Daten in der Session,
            // daher Formulardaten aus dem Datenbankobjekt übernehmen
            request.setAttribute("user_form", this.createUserForm(user));
        }

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/benutzerkonto/benutzerkonto_edit.jsp").forward(request, response);
        
        session.removeAttribute("user_form");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Angeforderte Aktion ausführen
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "save":
                this.saveUser(request, response);
                break;
            case "delete":
                this.deleteUser(request, response);
                break;
        }
    }

    /**
     * Aufgerufen in doPost(): Neue oder vorhandene Aufgabe speichern
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void saveUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Formulareingaben prüfen
        List<String> errors = new ArrayList<>();

        String userUsername = request.getParameter("user_username");
        String userFirstname = request.getParameter("user_firstname");
        String userLastname = request.getParameter("user_lastname");
        String userEmail = request.getParameter("user_Email");
       

        User user = this.getRequestedUser(request);

 

        user.setUsername(userUsername);
        user.setFirstname(userFirstname);
        user.setLastname(userLastname);
        

        this.validationBean.validate(user, errors);

        // Datensatz speichern
        if (errors.isEmpty()) {
            this.userBean.update(user);
        }

        // Weiter zur nächsten Seite
        if (errors.isEmpty()) {
            // Keine Fehler: Startseite aufrufen
            response.sendRedirect(WebUtils.appUrl(request, "/app/benutzerkonto/konto/"));
        } else {
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);

            HttpSession session = request.getSession();
            session.setAttribute("user_form", formValues);

            response.sendRedirect(request.getRequestURI());
        }
    }

    /**
     * Aufgerufen in doPost: Vorhandene Aufgabe löschen
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Datensatz löschen
        User user = this.getRequestedUser(request);
        this.userBean.delete(user);

        // Zurück zur Übersicht
        response.sendRedirect(WebUtils.appUrl(request, "/app/benutzerkonto/konto/"));
    }

    /**
     * Zu bearbeitende Aufgabe aus der URL ermitteln und zurückgeben. Gibt
     * entweder einen vorhandenen Datensatz oder ein neues, leeres Objekt
     * zurück.
     *
     * @param request HTTP-Anfrage
     * @return Zu bearbeitende Aufgabe
     */
    private User getRequestedUser(HttpServletRequest request) {
        // Zunächst davon ausgehen, dass ein neuer Satz angelegt werden soll
       User user = new User();
     
      

        // Versuchen, den Datensatz mit der übergebenen ID zu finden
        try {
            user = this.userBean.getCurrentUser();
        } catch (NumberFormatException ex) {
            // Ungültige oder keine ID in der URL enthalten
        }

        return user;
    }

    /**
     * Neues FormValues-Objekt erzeugen und mit den Daten eines aus der
     * Datenbank eingelesenen Datensatzes füllen. Dadurch müssen in der JSP
     * keine hässlichen Fallunterscheidungen gemacht werden, ob die Werte im
     * Formular aus der Entity oder aus einer vorherigen Formulareingabe
     * stammen.
     *
     * @param user Die zu bearbeitende Aufgabe
     * @return Neues, gefülltes FormValues-Objekt
     */
    private FormValues createUserForm(User user) {
        Map<String, String[]> values = new HashMap<>();

        values.put("user_username", new String[]{
            user.getUsername()
        });

        
         values.put("user_firstname", new String[]{
            user.getFirstname()
        });
         
         values.put("user_lastname", new String[]{
            user.getLastname()
        });
         
          values.put("user_email", new String[]{
            user.getEmail()
        });
      
        FormValues formValues = new FormValues();
        formValues.setValues(values);
        return formValues;
    }

}




    
