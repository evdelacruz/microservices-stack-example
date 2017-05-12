package org.jsamples.microservices.citizen.services.datasource.domain;

import java.io.Serializable;

public class Citizen implements Serializable {
    private static final long serialVersionUID = -2399802071622476706L;
    private int id;
    private String DNI;
    private String name;
    private int age;

    public Citizen() {}

    //<editor-fold desc="Encapsulation">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //</editor-fold>
}
