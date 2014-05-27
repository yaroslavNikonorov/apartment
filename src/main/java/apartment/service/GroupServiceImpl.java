package apartment.service;

import apartment.domain.Group;
import apartment.domain.User;
import apartment.repository.GroupRepository;
import apartment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 5/21/14.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Override
    public Iterable<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(Group group) {
        repository.save(group);
    }

    @Override
    public Group findById(Long id) {
        return repository.findById(id);
    }


}
