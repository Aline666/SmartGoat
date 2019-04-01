
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.web;

import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.ejb.AnimalBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.ejb.SpeciesBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Animal;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.AnimalStatus;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Species;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laurahetzel
 */
   /**
 * Servlet für die tabellarische Auflisten der Aufgaben.
 */


@WebServlet(urlPatterns = {"/app/Tierdashboard/list/"})
public class AnimalListServlet extends HttpServlet{
    

    @EJB
    private SpeciesBean speciesBean;
    
    @EJB
    private AnimalBean animalBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verfügbare Kategorien und Stati für die Suchfelder ermitteln
        request.setAttribute("species", this.speciesBean.findAllSorted());
        request.setAttribute("statuses", AnimalStatus.values());

        // Suchparameter aus der URL auslesen
        String searchSpecies = request.getParameter("search_species");
        String searchStatus = request.getParameter("search_status");

        // Anzuzeigende Aufgaben suchen
        Species species = null;
        AnimalStatus status = null;

        if (searchSpecies != null) {
            try {
                species = this.speciesBean.findById(Long.parseLong(searchSpecies));
            } catch (NumberFormatException ex) {
                species = null;
            }
        }

        if (searchStatus != null) {
            try {
                status = AnimalStatus.valueOf(searchStatus);
            } catch (IllegalArgumentException ex) {
                status = null;
            }

        }

        List<Animal> animals = this.animalBean.search(species, status);
        request.setAttribute("animals", animals);

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/Tierdashboard/animal_list.jsp").forward(request, response);
    }
}

    

