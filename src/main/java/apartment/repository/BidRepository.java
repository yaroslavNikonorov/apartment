package apartment.repository;

import apartment.domain.Bid;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yar on 6/13/14.
 */
public interface BidRepository extends CrudRepository<Bid, Long> {
    Bid findById(Long id);
}
