/* 
    Document   : rollenVerw
    Created on : 24.03.2019, 13:22:10
    Author     : a.schaub
*/
package SmartgoatServlet;

import Smartgoat.EJB.RollenBean;
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
    private CategoryBean categoryBean;
    
    @EJB
    private TaskBean taskBean;
    
    @EJB private RollenBean rollenBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verfügbare Kategorien und Stati für die Suchfelder ermitteln
        request.setAttribute("categories", this.categoryBean.findAllSorted());
        request.setAttribute("statuses", TaskStatus.values());

        // Suchparameter aus der URL auslesen
        String searchText = request.getParameter("search_text");
        String searchCategory = request.getParameter("search_category");
        String searchStatus = request.getParameter("search_status");

        // Anzuzeigende Aufgaben suchen
        Category category = null;
        TaskStatus status = null;

        if (searchCategory != null) {
            try {
                category = this.categoryBean.findById(Long.parseLong(searchCategory));
            } catch (NumberFormatException ex) {
                category = null;
            }
        }

        if (searchStatus != null) {
            try {
                status = TaskStatus.valueOf(searchStatus);
            } catch (IllegalArgumentException ex) {
                status = null;
            }

        }

        List<Task> tasks = this.taskBean.search(searchText, category, status);
        request.setAttribute("tasks", tasks);

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/Rollenverwaltung/rollenansicht.jsp").forward(request, response);
    }
}

