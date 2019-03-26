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

import Smartgoat.jpa.roles;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 * Einfache EJB mit den üblichen CRUD-Methoden für Aufgaben
 */
@Stateless
@RolesAllowed({"app-user", "admin"})
public class RollenBean extends EntityBean<roles, Long> { 
   
    public RollenBean() {
        super(roles.class);
    }
    
    /**
     * Alle Aufgaben eines Benutzers, nach Fälligkeit sortiert zurückliefern.
     * @param username Benutzername
     * @param groupname Gruppenname
     * @return Alle Aufgaben des Benutzers
     */
    public List<Task> findAccountGroup(String username, String groupname) {
        return em.createQuery("SELECT username, groupname FROM SMARTGOAT_USER_GROUP")
                 .setParameter("username", username)
                .setParameter("groupname", groupname)
                 .getResultList();       
    }
}
