package apartment.service;

import apartment.domain.Apartment;
import apartment.domain.Bid;
import apartment.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 5/23/14.
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository repository;

    @Override
    public void add(Apartment apartment) {
        repository.save(apartment);
    }

    @Override
    public Apartment find(String address) {
        return repository.findByAddress(address);
    }

    @Override
    public Iterable<Apartment> all() {
        return repository.findAll();
    }

    @Override
    public Apartment findById(Long id) {
        return repository.findById(id);
    }
}
