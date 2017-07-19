package org.jsamples.microservices.product.services.datasource.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 124345638681941737L;
    private int id;
    private ProductType type;
    private String code;
    private int price;

    public Product() {}

    //<editor-fold desc="Encapsulation">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //</editor-fold>
}
