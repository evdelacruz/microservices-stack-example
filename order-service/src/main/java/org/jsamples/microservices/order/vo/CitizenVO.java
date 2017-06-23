package org.jsamples.microservices.citizen.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CitizenVO implements Serializable {
    private static final long serialVersionUID = 9026318673256920702L;
    private int id;
    private String DNI;
    private String name;
    private int age;

    public CitizenVO() {}

    //<editor-fold desc="Encapsulation">
    @JsonProperty(access=JsonProperty.Access.READ_ONLY)
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
