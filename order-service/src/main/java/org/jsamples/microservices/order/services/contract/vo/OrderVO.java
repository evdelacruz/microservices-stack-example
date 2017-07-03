package org.jsamples.microservices.order.services.contract.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class OrderVO implements Serializable {
    private static final long serialVersionUID = -3844273903298246103L;
    private int id;
    private CitizenVO holder;
    private ProductVO product;
    private int price;

    public OrderVO() {}

    //<editor-fold desc="Encapsulation">
    @JsonProperty(access=JsonProperty.Access.READ_ONLY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CitizenVO getHolder() {
        return holder;
    }

    public void setHolder(CitizenVO holder) {
        this.holder = holder;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //</editor-fold>
}
