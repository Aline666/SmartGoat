/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package Smartgoat.EJB;

import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.ejb.*;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.TaskStatus;
import java.io.Serializable;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Einfache EJB mit den üblichen CRUD-Methoden für Aufgaben
 */

   
@Entity
public class RollenBean implements Serializable {
    
    @PersistenceContext
    EntityManager em;
    @Id
    private Long id;

    private RollenBean(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

@Stateless
@RolesAllowed({"app-user", "admin"})
public class RollenUser {

    // Damit greifen wir auf die Datenbank zu
    @PersistenceContext
    EntityManager em;

    public List<RollenUser> findAllEntries() { return null;
}
    public RollenUser createNewEntry(String name) {return null; }
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}


