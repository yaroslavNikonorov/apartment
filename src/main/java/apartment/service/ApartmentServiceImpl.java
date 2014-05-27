package apartment.service;

import apartment.domain.Apartment;
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
    public Apartment find(String name) {
        return repository.findByName(name);
    }

    @Override
    public Iterable<Apartment> all() {
        return repository.findAll();
    }
}
