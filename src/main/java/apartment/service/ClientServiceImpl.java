package apartment.service;

import apartment.domain.Client;
import apartment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 6/5/14.
 */
@Service
public class ClientServiceImpl implements ClientService {
    public static Object serviceType = Client.class;

    @Autowired
    private ClientRepository repository;

    @Override
    public void add(Client client) {
        repository.save(client);
    }

}
