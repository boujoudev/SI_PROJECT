package tp.si.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.si.conference.entities.*;
import tp.si.conference.repositories.EvaluationRepository;
import tp.si.conference.repositories.SoumissionRepository;
import tp.si.conference.repositories.UserRepository;

import java.util.List;

@Service
public class R_editeurService {

    @Autowired
    private SoumissionRepository soumissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;


    public boolean affecterSoumission(Long idSoumission, int idEvaluateur) {
        // Récupérer la soumission
        Soumission soumission = soumissionRepository.findById(String.valueOf(idSoumission))
                .orElseThrow(() -> new RuntimeException("Soumission introuvable avec ID : " + idSoumission));

        // Récupérer l'évaluateur
        User evaluateur = userRepository.findById(String.valueOf(idEvaluateur))
                .orElseThrow(() -> new RuntimeException("Évaluateur introuvable avec ID : " + idEvaluateur));

        // Vérifie si l'utilisateur est un évaluateur
        if (evaluateur.getRoles().stream().noneMatch(role -> "REvaluateur".equalsIgnoreCase(role.getNom_role()))) {
            System.out.println("Échec : L'utilisateur n'est pas un évaluateur.");
            return false;
        }

        // Ajouter l'évaluateur à la soumission
        soumission.getEvaluateurs().add(evaluateur);
        soumissionRepository.save(soumission);

        System.out.println("Soumission affectée avec succès à l'évaluateur !");
        return true;
    }


    public List<Evaluation> consulterEvaluations(Long idSoumission) {
        List<Evaluation> evaluations = evaluationRepository.findBySoumissionId(String.valueOf(idSoumission));

        if (evaluations.isEmpty()) {
            System.out.println("Aucune évaluation trouvée pour la soumission avec ID : " + idSoumission);
        } else {
            evaluations.forEach(evaluation -> {
                System.out.println("Note : " + evaluation.getNote());
                System.out.println("Commentaires : " + evaluation.getCommentaires());
                System.out.println("État : " + evaluation.getEtat());
            });
        }

        return evaluations;
    }
}