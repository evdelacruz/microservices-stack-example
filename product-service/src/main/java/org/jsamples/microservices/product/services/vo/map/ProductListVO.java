package org.jsamples.microservices.product.services.vo.map;

public class ProductListVO extends BaseProductVO {
    private static final long serialVersionUID = 4493099909247181447L;
    private String code;
    private int price;

    public ProductListVO() {}

    //<editor-fold desc="Encapsulation">
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
