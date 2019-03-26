
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DB Klasse für ein Tier 
 * @author laurahetzel
 */

@Entity
@Table(name = "SMARTGOAT_ANIMAL")
public class Animal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "animal_ids")
    @TableGenerator(name = "animal_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
    
    @Column(name = "animalname", length = 64)
    @Size(min = 3, max = 64, message = "Der Tiername muss zwischen drei und 64 Zeichen lang sein.")
    @NotNull(message = "Der Tiername darf nicht leer sein.")
    private String animalname;
    
    

    @ManyToOne
    private Species species;
    

    @Column(length = 100)
    @NotNull(message = "Die medizinischen Informationen dürfen nicht leer sein.")
    @Size(min = 1, max = 10, message = "Die Bezeichnung muss zwischen ein und 100 Zeichen lang sein.")
    private String longText;


    @NotNull(message = "Das Eingansdatum darf nicht leer sein.")
    private Date dueDate;


    @Enumerated(EnumType.STRING)
    @NotNull
    private AnimalStatus status = AnimalStatus.GeradeEingetroffen;

    public Animal(long id, String animalname, Species species, String longText, Date dueDate) {
        this.id = id;
        this.animalname = animalname;
        this.species = species;
        this.longText = longText;
        this.dueDate = dueDate;
    }

    public Animal() {
    }
    
    
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }
   
 
    
    
}