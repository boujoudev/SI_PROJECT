package tp.si.conference.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Soumission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id; // Identifiant unique pour la soumission

    private String titre; // Titre de l'article

    private String resume; // Résumé de l'article

    @Lob
    private byte[] pdf; // Contenu du document PDF

    @ManyToMany
    @JoinTable(
            name = "soumission_auteurs", // Table de liaison entre Soumission et Auteurs
            joinColumns = @JoinColumn(name = "soumission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> auteurs=new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "soumission_evaluateurs", // Table de liaison entre Soumission et evaluateurs
            joinColumns = @JoinColumn(name = "soumission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> evaluateurs =new ArrayList<>(); // Liste des auteurs de l'article

    @ManyToOne
    private Conference conference ; // Conférence associée à la soumission

    // Constructeurs
    public Soumission() {}

    public Soumission(String titre, String resume, byte[] pdf, List<User> auteurs, Conference conference) {
        this.titre = titre;
        this.resume = resume;
        this.pdf = pdf;
        this.auteurs = auteurs;
        this.conference = conference;
    }
}