/* 
    Document   : Roles
    Created on : 24.03.2019, 13:08:19
    Author     : a.schaub
*/
package dhbwka.wwi.vertsys.javaee.smartgoat.roles.jpa;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Eine zu erledigende Aufgabe.
 */
@Entity
@Table(name = "ROLES")
public class Roles implements Serializable {
 
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USERNAME", length = 64)
    @Size(min = 5, max = 64, message = "Der Benutzername muss zwischen fünf und 64 Zeichen lang sein.")
    @NotNull(message = "Der Benutzername darf nicht leer sein.")
    private String username;
    
    

    
    @Column(name = "GROUPNAME")
    private String groupname;
    /*
    @JoinColumns({
        @JoinColumn(name="USERNAME"),
        @JoinColumn(name="GROUPNAME")
    })
     User groupname;
    
*/
    
    /*
    
    @Column(name="adminJN")
        boolean adminJN = false;

*/
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Roles() {
    }

    public Roles(String username, String groupname) {
        this.username = username;
        this.groupname = groupname;
    }
    //</editor-fold>

    /*Username abfragen*/
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    

    /*Gruppennamen abfragen*/
    public String getGroupname() {
    return groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
    /*
    
    /*Checkbox abfragen
        public Boolean getAdminState() {
        return adminJN;
    }
    */
        /*
    public void setAdminState(Boolean adminJN) {
        this.adminJN = adminJN;
    }

    public void setAdminJN(Boolean adminJN) {
    }

*/
         
}

