package apartment.service;

import apartment.domain.Group;

/**
 * Created by yar on 5/21/14.
 */
public interface GroupService {
    Iterable<Group> getAll();
    void add(Group group);
    Group findById(Long id);
}
