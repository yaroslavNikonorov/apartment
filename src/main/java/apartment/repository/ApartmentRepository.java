package apartment.repository;

import apartment.domain.Apartment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yar on 5/23/14.
 */
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
    Apartment findByName(String name);
}
