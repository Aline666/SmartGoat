/* 
    Document   : rollenVerw
    Created on : 24.03.2019, 13:22:10
    Author     : a.schaub
*/
package SmartgoatServlet;

import Smartgoat.EJB.RollenBean;
import Smartgoat.EJB.UserRollenBean;
import Smartgoat.jpa.roles;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.ejb.CategoryBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.TaskStatus;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/app/rollenVerwaltung/"})
public class RollenVerwaltungServlet extends HttpServlet {

@EJB 
private UserRollenBean userrollenBean;
    
@EJB
private RollenBean rollenBean;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        
            List<roles> groupList = (List<roles>) this.rollenBean.getAllGroups();
            request.setAttribute("nutzerliste", groupList);
            
            List<roles> userList = (List<roles>) this.userrollenBean.getAllUser();
            request.setAttribute("gruppenliste", userList);
          
            /*
            List<roles> groupList = (List<roles>) this.rollenBean.getAllGroups();
            request.setAttribute("gruppenliste", groupList);
            
 */

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/Rollenverwaltung/rollenansicht.jsp").forward(request, response);
    }
}

