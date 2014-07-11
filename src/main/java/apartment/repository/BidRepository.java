package apartment.repository;

import apartment.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yar on 6/13/14.
 */
public interface BidRepository extends JpaRepository<Bid, Long> {
    Bid findById(Long id);
}
