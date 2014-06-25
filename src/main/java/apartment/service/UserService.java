package apartment.service;

import apartment.domain.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by yar on 5/21/14.
 */
public interface UserService {
    Iterable<User> getAll();
    Collection<String> getNames();
    void add(User client);
}
