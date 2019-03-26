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
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
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

    private Object username;
    private Object groupname;
    private Object groups;
   
    public RollenBean() {
        super(roles.class);
    }
    
    /**
     * Alle Gruppennamen in einer Liste zusammenfügen
     * @param username Benutzername
     * @param groupname Gruppenname
     */
    @RolesAllowed({"admin", "app-user"})
    public List<roles> getAllGroups(){
        return this.em.createQuery("SELECT f from User f where f.username like :username and f.groups like :groups")
                .setParameter("username", username)
                .setParameter("groups", groups)
                .getResultList();
    }
    
    /*public List<Film> sucheNameUndJahr(
        String name, int vonJahr, int bisJahr) {

            return em.createQuery(
                        "SELECT f FROM Film f"
                      + "  WHERE f.name LIKE :name"
                      + "    AND f.jahr BETWEEN :von AND :bis"
*/

    
    }
    

    
    

