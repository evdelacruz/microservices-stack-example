package org.jsamples.microservices.citizen.services.datasource;

import org.jsamples.microservices.citizen.services.datasource.domain.Citizen;

public interface CitizenRepository {

    int add(Citizen citizen);

    Citizen get(int id);
}
