package apartment.service;

import apartment.domain.Client;

import java.util.List;

/**
 * Created by yar on 4/10/14.
 */
public interface ClientService {
    void addClient(Client client);
    List<Client> getAll();
}
