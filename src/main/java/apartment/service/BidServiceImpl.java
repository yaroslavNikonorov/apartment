package apartment.service;

import apartment.domain.Bid;
import apartment.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 6/13/14.
 */
@Service
public class BidServiceImpl implements BidService{

    @Autowired
    private BidRepository repository;

    @Override
    public void add(Bid bid) {
        repository.save(bid);
    }

//    @Override
//    public Object findById(Long id) {
//        return repository.findById(id);
//    }
}
