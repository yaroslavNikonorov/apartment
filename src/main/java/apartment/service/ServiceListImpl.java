package apartment.service;

import apartment.domain.Apartment;
import apartment.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yar on 6/19/14.
 */
@Service
public class ServiceListImpl {

    private Map<Object, Object> services = new HashMap<Object, Object>();

    @Autowired
    private ClientService clientService;

    @Autowired
    private ApartmentService apartmentService;

    public ServiceListImpl() {
        services.put(Client.class, clientService);
        services.put(Apartment.class, apartmentService);
    }

    public Object getService(Object obj){
        for(Object type:services.keySet()){
            if(type.equals(obj)){
                return services.get(type);
            }
        }
        return null;
    }
}
