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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Eine zu erledigende Aufgabe.
 */
@Entity
public class roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "task_ids")

    @OneToMany
    private User groupname;
    @OneToOne
    private User username;
    @Id
    private Long id;

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
