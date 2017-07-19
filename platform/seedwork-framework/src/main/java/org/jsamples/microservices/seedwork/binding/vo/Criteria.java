package org.jsamples.microservices.seedwork.binding.vo;

import java.util.List;

public class Criteria {
    protected List<String> fields;

    //<editor-fold desc="Encapsulation">
    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }
    //</editor-fold>
}
