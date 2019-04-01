/**
 * Servlet für die Benutzerdaten anzeigen
 */
package dhbwka.wwi.vertsys.javaee.smartgoat.account.profil;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/app/profil/"})
public class profilViewServlet extends HttpServlet {
    
    @EJB
    UserBean userBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = userBean.getCurrentUser();
        request.setAttribute("user", user);
        
        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/benutzerkonto/benutzerkonto_list.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // Angeforderte Aktion ausführen
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "profil_edit":
                response.sendRedirect(WebUtils.appUrl(request, "/app/profil/edit/"));
                break;
        }
    }

}