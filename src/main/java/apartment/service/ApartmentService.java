package apartment.service;

import apartment.domain.Apartment;
import apartment.domain.Bid;

/**
 * Created by yar on 5/23/14.
 */
public interface ApartmentService {
    void add(Apartment apartment);
    Apartment find(String address);
    Iterable<Apartment> all();
    Apartment findById(Long id);
}
