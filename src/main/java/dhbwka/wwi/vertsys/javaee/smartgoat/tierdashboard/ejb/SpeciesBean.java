 
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa.Species;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author laurahetzel
 */

    
   /**
 * Einfache EJB mit den üblichen CRUD-Methoden für Kategorien.
 */
@Stateless
@RolesAllowed({"app-user"})
public class SpeciesBean extends EntityBean<Species, Long>  {
    


    public SpeciesBean() {
        super(Species.class);
    }

    /**
     * Auslesen aller Kategorien, alphabetisch sortiert.
     *
     * @return Liste mit allen Kategorien
     */
    public List<Species> findAllSorted() {
        return this.em.createQuery("SELECT c FROM Species c ORDER BY c.name").getResultList();
    }
}

    

