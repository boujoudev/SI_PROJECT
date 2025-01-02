package tp.si.conference.repositories;
import tp.si.conference.entities.Role;
import tp.si.conference.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    // Rechercher un rôle par ses trois composantes : user, conference et nomRole
    List<Role> findByUserIdAndConferenceIdAndNomRole(int userId, Long conferenceId, String nomRole);





        boolean existsByUserIdAndConferenceIdAndNomRole(int userId, Long conferenceId, String nomRole);

        User findUserById(int userId);

        Conference findConferenceById(Long conferenceId);
    }
