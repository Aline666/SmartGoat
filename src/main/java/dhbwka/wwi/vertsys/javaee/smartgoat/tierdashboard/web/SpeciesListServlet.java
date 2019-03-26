 
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.web;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.ejb.AnimalBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.ejb.SpeciesBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Animal;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Species;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = {"/app/Tierdashboard/species/"})
public class SpeciesListServlet extends HttpServlet{
    
    
    
    
/**
 * Seite zum Anzeigen und Bearbeiten der Kategorien. Die Seite besitzt ein
 * Formular, mit dem ein neue Kategorie angelegt werden kann, sowie eine Liste,
 * die zum Löschen der Kategorien verwendet werden kann.
 */

    @EJB
    SpeciesBean speciesBean;

    @EJB
    AnimalBean animalBean;

    @EJB
    ValidationBean validationBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Alle vorhandenen Kategorien ermitteln
        request.setAttribute("species", this.speciesBean.findAllSorted());

        // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Tierdashboard/species_list.jsp");
        dispatcher.forward(request, response);

        // Alte Formulardaten aus der Session entfernen
        HttpSession session = request.getSession();
        session.removeAttribute("species_form");
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
            case "create":
                this.createSpecies(request, response);
                break;
            case "delete":
                this.deleteSpecies(request, response);
                break;
        }
    }

    /**
     * Aufgerufen in doPost(): Neue Kategorie anlegen
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void createSpecies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Formulareingaben prüfen
        String name = request.getParameter("name");

       Species species= new Species(name);
        List<String> errors = this.validationBean.validate(species);

        // Neue Kategorie anlegen
        if (errors.isEmpty()) {
            this.speciesBean.saveNew(species);
        }

        // Browser auffordern, die Seite neuzuladen
        if (!errors.isEmpty()) {
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);

            HttpSession session = request.getSession();
            session.setAttribute("species_form", formValues);
        }

        response.sendRedirect(request.getRequestURI());
    }

    /**
     * Aufgerufen in doPost(): Markierte Kategorien löschen
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void deleteSpecies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Markierte Kategorie IDs auslesen
        String[] speciesIds = request.getParameterValues("species");

        if (speciesIds == null) {
            speciesIds = new String[0];
        }

        // Kategorien löschen
        for (String speciesId : speciesIds) {
            // Zu löschende Kategorie ermitteln
            Species species;

            try {
                species = this.speciesBean.findById(Long.parseLong(speciesId));
            } catch (NumberFormatException ex) {
                continue;
            }

            if (species == null) {
                continue;
            }

            // Bei allen betroffenen Aufgaben, den Bezug zur Kategorie aufheben
            List<Animal> animals = species.getAnimal();

            if (animals != null) {
                animals.forEach((Animal animal) -> {
                    animal.setSpecies(null);
                    this.animalBean.update(animal);
                });
            }

            // Und weg damit
            this.speciesBean.delete(species);
        }

        // Browser auffordern, die Seite neuzuladen
        response.sendRedirect(request.getRequestURI());
    }

}

    

