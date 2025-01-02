package tp.si.conference.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.si.conference.entities.Conference;
import tp.si.conference.entities.R_auteur;

import tp.si.conference.entities.Soumission;
import tp.si.conference.repositories.ConferenceRepository;
import tp.si.conference.repositories.SoumissionRepository;
import tp.si.conference.repositories.UserRepository;

import java.util.List;

@Service
public class R_auteurService {

    @Autowired
    private SoumissionRepository soumissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    public boolean soumettreArticle(Long idConf, String titre, String resume, byte[] pdf, R_auteur r_auteur) {
        // Vérifie si la conférence existe
        Conference conference = conferenceRepository.findById(String.valueOf(idConf))
                .orElseThrow(() -> new RuntimeException("Conférence introuvable avec ID : " + idConf));

        // Vérifie si la conférence est ouverte aux soumissions
        if (!"ouverte".equalsIgnoreCase(conference.getEtat_conference())) {
            System.out.println("Échec : La conférence n'est pas ouverte aux soumissions.");
            return false;
        }

        // Crée une nouvelle soumission
        Soumission nouvelleSoumission = new Soumission();
        nouvelleSoumission.setTitre(titre);
        nouvelleSoumission.setResume(resume);
        nouvelleSoumission.setPdf(pdf);
        nouvelleSoumission.setConference(conference);

        // Ajoute l'auteur actuel (R_auteur est un rôle d'utilisateur)
        if (r_auteur.getUser() != null) {
            nouvelleSoumission.setAuteurs(List.of(r_auteur.getUser())); // Ajoute l'auteur en tant qu'utilisateur
        } else {
            System.out.println("Échec : Aucune information utilisateur associée à ce rôle.");
            return false;
        }

        // Sauvegarde la soumission
        soumissionRepository.save(nouvelleSoumission);

        System.out.println("Soumission réussie pour la conférence : " + conference.getTitre());
        return true;
    }
}


