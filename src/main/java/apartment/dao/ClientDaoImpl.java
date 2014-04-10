package apartment.dao;

import apartment.domain.Client;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yar on 4/10/14.
 */
@Repository
public class ClientDaoImpl implements ClientDao{

    @Autowired
    private SessionFactory factory;

    @Override
    public void add(Client client) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> getAll() {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Client.class);
        return crit.list();
    }
}
