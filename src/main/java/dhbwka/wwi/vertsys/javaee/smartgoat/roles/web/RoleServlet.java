/* 
    Document   : RoleServlet
    Created on : 24.03.2019, 13:22:10
    Author     : a.schaub
 */
package dhbwka.wwi.vertsys.javaee.smartgoat.roles.web;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils;
import dhbwka.wwi.vertsys.javaee.smartgoat.roles.ejb.RoleBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@WebServlet(urlPatterns = {"/app/rollenVerwaltung/"})
public class RoleServlet extends HttpServlet {

    @EJB
    private RoleBean rollenBean;

    @EJB
    private UserBean userBean;

    @Override
    @Transactional
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> userList = userBean.findAll();
        request.setAttribute("userList", userList);

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/Rollenverwaltung/rollenansicht.jsp").forward(request, response);
        
        // Alte Fehlermeldungen löschen
        request.getSession().removeAttribute("errorMessages");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> errorMessages = new ArrayList<>();

        String username = request.getParameter("username");
        String action = request.getParameter("action");

        if (username == null || username.trim().isEmpty()) {
            // Fehler: Benutzername nicht mitgegeben
            errorMessages.add("Benutzername fehlt");
        }

        if (action == null || action.trim().isEmpty()) {
            // Fehler: Aktion nicht mitgebenen
            errorMessages.add("Aktion fehlt");
        }

        User user = userBean.findByUsername(username);

        if (user == null) {
            // Fehler: Unbekannter User
            errorMessages.add("Unbekannter Benutzer " + username);
        }

        if (user != null && action != null && errorMessages.isEmpty()) {
            switch (action) {
                case "set-admin":
                    user.addToGroup("admin");
                    break;
                case "unset-admin":
                    user.removeFromGroup("admin");
                    break;
                default:
                // Fehler: Unbekannte Aktion
            }

            userBean.update(user);
        }
        
        request.getSession().setAttribute("errorMessages", errorMessages);
        response.sendRedirect(WebUtils.appUrl(request, "/app/rollenVerwaltung/"));
    }
}
