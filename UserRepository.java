package tp.si.conference.repositories;
import org.springframework.data.repository.CrudRepository;
import tp.si.conference.entities.User;


public interface UserRepository extends CrudRepository<User, String> {
}
