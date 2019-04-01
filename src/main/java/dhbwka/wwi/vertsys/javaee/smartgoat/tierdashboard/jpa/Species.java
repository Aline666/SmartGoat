
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author laurahetzel
 */

@Entity
public class Species implements Serializable{
    

    private static final long serialVersionUID = 1L;
   
    

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "species_ids")
    @TableGenerator(name = "species_ids", initialValue = 0, allocationSize = 50)
    private long id;

    @Column(length = 30)
    @NotNull(message = "Der Name darf nicht leer sein.")
    @Size(min = 3, max = 30, message = "Der Name muss zwischen drei und 30 Zeichen lang sein.")
    private String name;

    @OneToMany(mappedBy = "species", fetch = FetchType.LAZY)
    List<Animal> animal = new ArrayList<>();

    public Species(String name) {
     
        this.name = name;
    }

    public Species() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
    
    
    
    
    
}
