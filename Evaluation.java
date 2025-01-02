package tp.si.conference.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Identifiant unique de l'évaluation

    private int note; // Note attribuée à la soumission (ex. : de 1 à 10)

    @Lob
    private String commentaires; // Commentaires détaillés de l'évaluateur

    private String etat; // État de l'évaluation (acceptée, rejetée, en révision)

    @ManyToOne
    @JoinColumn(name = "soumission_id", nullable = false) // Clé étrangère vers Soumission
    private Soumission soumission; // Soumission évaluée

    @ManyToOne
    @JoinColumn(name = "evaluateur_id", nullable = false) // Clé étrangère vers User (évaluateur)
    private User evaluateur; // Évaluateur ayant effectué l'évaluation

    // Constructeurs
    public Evaluation() {}

    public Evaluation(int note, String commentaires, String etat, Soumission soumission, User evaluateur) {
        this.note = note;
        this.commentaires = commentaires;
        this.etat = etat;
        this.soumission = soumission;
        this.evaluateur = evaluateur;
    }
}