package apartment.repository;

import apartment.domain.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yar on 6/5/14.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findById(Long id);
}
