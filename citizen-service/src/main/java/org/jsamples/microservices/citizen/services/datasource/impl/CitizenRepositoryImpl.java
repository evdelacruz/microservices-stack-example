package org.jsamples.microservices.citizen.services.datasource.impl;

import org.jsamples.microservices.citizen.services.datasource.CitizenRepository;
import org.jsamples.microservices.citizen.services.datasource.domain.Citizen;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository("citizenRepository")
public class CitizenRepositoryImpl implements CitizenRepository {
    private Map<Integer, Citizen> collection;
    private int counter;

    public CitizenRepositoryImpl() {
        collection = new ConcurrentHashMap<>(100);
        counter = 0;
    }

    @Override
    public int add(Citizen citizen) {
        int id = this.sequence();
        collection.put(id, citizen);
        return id;
    }

    @Override
    public Citizen get(int id) {
        Citizen citizen = collection.get(id);
        if (null != citizen) {
            citizen.setId(id);
        }
        return citizen;
    }

    //<editor-fold desc="Support methods">
    private synchronized int sequence() {
        return ++counter;
    }
    //</editor-fold>
}
