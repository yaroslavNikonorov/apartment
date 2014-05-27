package apartment.service;

import apartment.domain.User;

/**
 * Created by yar on 5/21/14.
 */
public interface UserService {
    Iterable<User> getAll();
    void add(User client);
}
