/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.smartgoat.roles.jpa;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Eine zu erledigende Aufgabe.
 */
@Entity
@Table(name = "ROLES")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id")
    @TableGenerator(name = "user_id", initialValue = 0, allocationSize = 50)
    private long id;
    
    
    @Column(name = "groupname", length = 10)
    private String groupname;
    
    @Column(name="username", length = 10)
    private String username;


    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Roles() {
    }

    public Roles(String username, String groupname) {
        this.username = username;
        this.groupname = groupname;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

        public String getGroupname() {
        return groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = username;
    }
    

    
   
}

