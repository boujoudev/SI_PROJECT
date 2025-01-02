package tp.si.conference.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Role {

    @Id
    private String nom_role;


    @ManyToOne
    private User user;


    @ManyToOne
    private Conference conference;



    public Role(String nom,User user,Conference conference){
        this.nom_role = nom;
        this.conference = conference;
        this.user = user;
    }

    public Role() {

    }
}
