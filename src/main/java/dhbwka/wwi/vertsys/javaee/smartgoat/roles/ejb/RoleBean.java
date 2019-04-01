/* 
    Document   : RoleBean
    Created on : 24.03.2019, 13:08:19
    Author     : a.schaub
*/
package dhbwka.wwi.vertsys.javaee.smartgoat.roles.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.roles.jpa.Roles;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import java.util.ArrayList;
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
    
    /*
    @RolesAllowed({"app-user","admin"})
    public User update(User user) {
        return em.merge(user);
    }
    
    */
    
                
    
/*
    @RolesAllowed({"admin", "app-user"})
    public List<Roles> getAllGroups(){
        return this.em.createQuery("SELECT f from Roles f")
                .getResultList();
    }
  */  
    
    /*
         @RolesAllowed({"admin", "app-user"})
    public List<Roles> getAllRoles(List<String> groups, List<String> user){
        return this.em.createQuery("SELECT p FROM User t JOIN t.username")
                .getResultList();
    }
    
     /*   
    @RolesAllowed({"admin", "app-user"})
        public List<Roles> updateTable(String groups, User username){
        return this.em.createQuery("INSERT into Roles with USERNAME= :USERNAME, GROUPNAME= :groups from User")
                 .setParameter("username", username)
                 .setParameter("groups", username)
                .getResultList();
        
        
   
        
    */
    
}


    
    

