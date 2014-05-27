package apartment.repository;

import apartment.domain.Group;
import org.springframework.data.repository.CrudRepository;


public interface GroupRepository extends CrudRepository<Group, Long> {
    Group findById(Long id);
}
