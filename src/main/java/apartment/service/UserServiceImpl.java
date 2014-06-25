package apartment.service;

import apartment.domain.User;
import apartment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by yar on 5/21/14.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final User user = repository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("no such user: " + s);
        } else {
            return user;
        }
    }

    @Override
    public Collection<String> getNames() {
        Collection<String> names= new TreeSet<String>();
        for(User user: repository.findAll()){
            names.add(user.getUsername());
        }
        return names;
    }
}
