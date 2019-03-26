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
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.TaskStatus;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Eine zu erledigende Aufgabe.
 */
@Entity
public class roles implements Serializable {


    private static final long serialVersionUID = 1L;

private String username;
private String groupname;
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public roles() {
    }

    public roles(String username, String groupname) {
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
        return username;
    }
    
    public void setGroupname(String groupname) {
        this.username = username;
    }
}

