package org.jsamples.microservices.product.services.vo.map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductVO extends BaseProductVO {
    private static final long serialVersionUID = -4542717530107302087L;
    private int id;
    private String type;
    private String code;
    private int price;

    public ProductVO() {}

    //<editor-fold desc="Encapsulation">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NotNull
    @Pattern(regexp="[A-Z]{3}-[0-9]{5}")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Min(1)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //</editor-fold>
}
