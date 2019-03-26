/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package Smartgoat.jpa;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Eine zu erledigende Aufgabe.
 */
@Entity
@Table(name = "SMARTGOAT_GROUP_ADMINISTRATION")
public class roles implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "role_ids")
    

    private User groupname;
    private User username;


    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">

    /**
     *
     */
    public roles() {
    }

    public roles(User username, User groupname) {
        this.username = username;
        this.groupname = groupname;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">


    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
    public User getGroupName() {
        return username;
    }

    public void setGroupName(User groupname) {
        this.groupname = groupname;
    }


    //</editor-fold>


}
