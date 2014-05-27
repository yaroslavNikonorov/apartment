package apartment.service;

import apartment.domain.User;
import apartment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 5/21/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<User> getAll() {
        return repository.findAll();
    }

    @Secured("ROLE_USER")
    @Override
    public void add(User client) {
        repository.save(client);
    }
}
