/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.smartgoat.roles.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.roles.jpa.Roles;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Einfache EJB mit den üblichen CRUD-Methoden für Aufgaben
 */
@Stateless
@RolesAllowed({"app-user", "admin"})
public class RoleBean extends EntityBean<User, Long> { 

    private Object username;
    private Object groupname;

    @PersistenceContext
    protected EntityManager em;
    

    protected EntityManager getEntityManager()
    {
        return em;
    }
    public RoleBean() {
        super(User.class);
    }
    
    
    /**
     * Alle Gruppennamen in einer Liste zusammenfügen
     * @param username Benutzername
     * @param groupname Gruppenname
     */
    

    @RolesAllowed({"admin", "app-user"})
    public List<Roles> getAllGroups(){
        return this.em.createQuery("SELECT f from Roles f where f.username like :username and f.groupname like :groupname")
                .setParameter("username", username)
                .setParameter("groupname", groupname)
                .getResultList();
    }
}
    

    
    

