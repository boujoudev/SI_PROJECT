package tp.si.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.si.conference.entities.Soumission;

import java.util.List;

@Repository
public interface SoumissionRepository extends JpaRepository<Soumission, String> {

    // Trouver toutes les soumissions d'une conférence
    List<Soumission> findByConferenceId(Long conferenceId);

    // Trouver toutes les soumissions d'un auteur spécifique
    List<Soumission> findByAuteursId(int auteurId);

    // Trouver toutes les soumissions d'une conférence pour un auteur spécifique
    List<Soumission> findByConferenceIdAndAuteursId(Long conferenceId, int auteurId);
    List<Soumission> findBySeasonId(int seasonId);
}
