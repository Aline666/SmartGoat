/* 
    Document   : RoleServlet
    Created on : 24.03.2019, 13:22:10
    Author     : a.schaub
*/
package dhbwka.wwi.vertsys.javaee.smartgoat.roles.web;


import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils;
import dhbwka.wwi.vertsys.javaee.smartgoat.roles.ejb.RoleBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.roles.jpa.Roles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/app/rollenVerwaltung/"})
public class RoleServlet extends HttpServlet {


    
@EJB
private RoleBean rollenBean;

@EJB
private UserBean userBean;




    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
        String user = request.getParameter("user");
        String groups = request.getParameter("groups");
        
        
        /*
            List<roles> groupList;
            groupList = (List<roles>) this.rollenBean.getAllGroups();
            request.setAttribute("groupList", groupList);
            
            
            List<roles> userList = (List<roles>) this.userrollenBean.getAllUser();
            request.setAttribute("gruppenliste", userList);
          
            */
            List<Roles> groupList = (List<Roles>) this.rollenBean.getAllGroups();
            request.setAttribute("groupList", groupList);
             

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/Rollenverwaltung/rollenansicht.jsp").forward(request, response);
    }
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    /**
     * Aufgerufen in doPost(): Neue oder vorhandene Aufgabe speichern
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
         
/*

    boolean adminJN= Boolean.parseBoolean(request.getParameter("adminJN"));

    Roles roles = null;
    roles.setAdminJN(adminJN);

        

     */  
        
    }
}

