package tp.si.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.si.conference.entities.Conference;


import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, String> {

    // Trouver toutes les conférences par thématique
    List<Conference> findByThematique(String thematique);

    // Trouver toutes les conférences par état
    List<Conference> findByEtatConference(String etatConference);

    // Trouver toutes les conférences entre deux dates
    List<Conference> findByDateDeutBetween(java.util.Date startDate, java.util.Date endDate);
}