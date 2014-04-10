package apartment.dao;

import apartment.domain.Client;

import java.util.List;

/**
 * Created by yar on 4/10/14.
 */
public interface ClientDao {
    void add(Client client);
    List<Client> getAll();
}
