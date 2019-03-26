
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Animal;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.AnimalStatus;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Species;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author laurahetzel
 */

@Stateless
@RolesAllowed("app-user")
public class AnimalBean extends EntityBean<Animal, Long>{
    
    
    
/**
 * Einfache EJB mit den üblichen CRUD-Methoden für Aufgaben
 */
   
    public AnimalBean() {
        super(Animal.class);
    }
    
    /**
     * Alle Aufgaben eines Benutzers, nach Fälligkeit sortiert zurückliefern.
     * @param species Benutzername
     * @return Alle Aufgaben des Benutzers
     */
    public List<Animal> findBySpecies(Species species) {
        return em.createQuery("SELECT t FROM Task t WHERE t.species = :species ORDER BY t.dueDate")
                 .setParameter("species", species)
                 .getResultList();
    }
    
    /**
     * Suche nach Aufgaben anhand ihrer Bezeichnung, Kategorie und Status.
     * 
     * Anders als in der Vorlesung behandelt, wird die SELECT-Anfrage hier
     * mit der CriteriaBuilder-API vollkommen dynamisch erzeugt.
     * 
     * @param species Kategorie (optional)
     * @param status Status (optional)
     * @return Liste mit den gefundenen Aufgaben
     */
    public List<Animal> search(Species species, AnimalStatus status) {
        // Hilfsobjekt zum Bauen des Query
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        
        // SELECT t FROM Task t
        CriteriaQuery<Animal> query = cb.createQuery(Animal.class);
        Root<Animal> from = query.from(Animal.class);
        query.select(from);

        // ORDER BY dueDate, dueTime
        query.orderBy(cb.asc(from.get("dueDate")));
       
        Predicate p = cb.conjunction();
        
        
        // WHERE t.category = :category
        if (species != null) {
            p = cb.and(p, cb.equal(from.get("species"), species));
            query.where(p);
        }
        
        // WHERE t.status = :status
        if (status != null) {
            p = cb.and(p, cb.equal(from.get("status"), status));
            query.where(p);
        }
        
        return em.createQuery(query).getResultList();
    }
}

    

