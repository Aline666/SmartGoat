/* Servlet für die Auflistung der Kontodetails */

package dhbwka.wwi.vertsys.javaee.smartgoat.account.web;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/app/benutzerkonto/"})
public class AccountListServlet extends HttpServlet {

    @EJB
    UserBean userBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = userBean.getCurrentUser();
        request.setAttribute("user", user);
        
         // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/benutzerkonto/benutzerkonto.jsp").forward(request, response);
    }

}
