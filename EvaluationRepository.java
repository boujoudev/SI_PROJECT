package tp.si.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.si.conference.entities.Evaluation;
import tp.si.conference.entities.Soumission;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, String> {
    List<Evaluation> findBySoumissionId(String idSoumission) ;



}