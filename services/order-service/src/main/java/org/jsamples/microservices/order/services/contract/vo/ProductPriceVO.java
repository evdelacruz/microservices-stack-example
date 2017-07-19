package org.jsamples.microservices.order.services.contract.vo;

import org.jsamples.microservices.seedwork.binding.vo.ValueObject;

public class ProductPriceVO extends ValueObject {
    private static final long serialVersionUID = 918477885495795640L;
    private int price;

    //<editor-fold desc="Encapsulation">
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //</editor-fold>
}
