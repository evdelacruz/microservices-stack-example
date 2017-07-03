package org.jsamples.microservices.seedwork.binding.vo;

import java.util.List;

public class DinamicValueObject extends ValueObject {
    private static final long serialVersionUID = -8725073117295337684L;
    private List<String> fields;

    protected boolean shouldSkip(String field) {
        return null != fields && !fields.contains(field);
    }

    //<editor-fold desc="Encapsulation">
    public void setFields(List<String> fields) {
        this.fields = fields;
    }
    //</editor-fold>
}
