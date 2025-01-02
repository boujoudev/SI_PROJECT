package tp.si.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.si.conference.entities.*;
import tp.si.conference.repositories.EvaluationRepository;
import tp.si.conference.repositories.SoumissionRepository;

@Service
public class R_evaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private SoumissionRepository soumissionRepository;


    public boolean evaluerSoumission(Long idSoumission, R_evaluateur evaluateur, int note, String commentaires, String etat) {
        // Récupérer la soumission
        Soumission soumission = soumissionRepository.findById(String.valueOf(idSoumission))
                .orElseThrow(() -> new RuntimeException("Soumission introuvable avec ID : " + idSoumission));


        if (!soumission.getEvaluateurs().contains(evaluateur.getUser())) {
            System.out.println("Échec : Vous ne pouvez pas évaluer une soumission qui ne vous a pas été affectée.");
            return false;
        }

        // Vérifier que l'évaluateur n'est pas l'auteur de la soumission
        if (soumission.getAuteurs().contains(evaluateur.getUser())) {
            System.out.println("Échec : Vous ne pouvez pas évaluer votre propre soumission.");
            return false;
        }


        // Créer une nouvelle évaluation
        Evaluation evaluation = new Evaluation();
        evaluation.setSoumission(soumission);
        evaluation.setEvaluateur(evaluateur.getUser());
        evaluation.setNote(note);
        evaluation.setCommentaires(commentaires);
        evaluation.setEtat(etat);

        // Sauvegarder l'évaluation
        evaluationRepository.save(evaluation);

        System.out.println("Évaluation réussie pour la soumission : " + soumission.getTitre());
        return true;
    }
}