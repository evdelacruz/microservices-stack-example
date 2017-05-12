package org.jsamples.microservices.citizen.vo;

import org.jsamples.microservices.citizen.services.datasource.domain.Citizen;

public final class Mapper {

    static public Citizen map(CitizenVO source) {
        Citizen target = null;
        if (null != source) {
            target = new Citizen();
            target.setAge(source.getAge());
            target.setDNI(source.getDNI());
            target.setName(source.getName());
        }
        return target;
    }

    static public CitizenVO map(Citizen source) {
        CitizenVO target = null;
        if (null != source) {
            target = new CitizenVO();
            target.setId(source.getId());
            target.setAge(source.getAge());
            target.setDNI(source.getDNI());
            target.setName(source.getName());
        }
        return target;
    }

    private Mapper() {}
}
