package org.jsamples.microservices.citizen.services.impl;

import org.jsamples.microservices.citizen.services.CitizenService;
import org.jsamples.microservices.citizen.services.datasource.CitizenRepository;
import org.jsamples.microservices.citizen.vo.CitizenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.jsamples.microservices.citizen.vo.Mapper.*;

@Service("citizenService")
public class CitizenServiceImpl implements CitizenService {
    private @Autowired CitizenRepository citizenRepository;

    public CitizenServiceImpl() {}

    @Override
    public int addCitizen(CitizenVO citizen) {
        return null != citizen ? citizenRepository.add(map(citizen)) : 0;
    }

    @Override
    public CitizenVO loadCitizen(int id) {
        return map(citizenRepository.get(id));
    }
}
