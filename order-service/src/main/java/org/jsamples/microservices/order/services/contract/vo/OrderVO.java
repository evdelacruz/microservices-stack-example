package org.jsamples.microservices.order.services.contract.vo;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderVO implements Serializable {
    private static final long serialVersionUID = -3844273903298246103L;
    private Integer id;
    private String code;
    private LocalDateTime deliverDate;
    private Integer productId;
    private Integer price;

    public OrderVO() {}

    //<editor-fold desc="Encapsulation">
    @Null
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Pattern(regexp="[0-9]{1}-[A-Z]{5}")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotNull
    public LocalDateTime getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(LocalDateTime deliverDate) {
        this.deliverDate = deliverDate;
    }

    @NotNull
    @Min(1)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Null
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    //</editor-fold>
}
