package tp.si.conference.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String info;



    // affecter le rôle principale pour le user
    public abstract void main_role(Conference conference);


    //affecter différent role pour notre user
    public abstract void ajouter_role(String role,Conference conference);


    @Setter
    @Getter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Role> roles; // Liste des rôles associés à l'utilisateur


}