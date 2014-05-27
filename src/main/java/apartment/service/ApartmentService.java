package apartment.service;

import apartment.domain.Apartment;

/**
 * Created by yar on 5/23/14.
 */
public interface ApartmentService {
    void add(Apartment apartment);
    Apartment find(String name);
    Iterable<Apartment> all();
}
