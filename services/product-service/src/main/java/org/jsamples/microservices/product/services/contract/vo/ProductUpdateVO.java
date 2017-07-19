package org.jsamples.microservices.product.services.contract.vo;

import javax.validation.constraints.Min;

public class ProductUpdateVO extends BaseProductVO {
    private static final long serialVersionUID = -1447829274004178798L;
    private int id;
    private int price;

    public ProductUpdateVO() {}

    //<editor-fold desc="Encapsulation">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
