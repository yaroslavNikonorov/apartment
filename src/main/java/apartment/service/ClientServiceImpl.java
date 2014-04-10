package apartment.service;

import apartment.dao.ClientDao;
import apartment.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yar on 4/10/14.
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDao clientDao;

    @Override
    public void addClient(Client client) {
        clientDao.add(client);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }
}