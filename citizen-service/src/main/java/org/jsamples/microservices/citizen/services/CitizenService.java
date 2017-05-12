package org.jsamples.microservices.citizen.services;

import org.jsamples.microservices.citizen.vo.CitizenVO;

public interface CitizenService {

    int addCitizen(CitizenVO citizen);

    CitizenVO loadCitizen(int id);
}
