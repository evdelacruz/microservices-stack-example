package org.jsamples.microservices.product.services.contract.vo;

import org.jsamples.microservices.product.services.contract.validation.constraints.UniqueCode;
import org.jsamples.microservices.seedwork.binding.vo.DinamicValueObject;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ProductVO extends DinamicValueObject {
    private static final long serialVersionUID = -4542717530107302087L;
    private Integer id;
    private String type;
    private String code;
    private Integer price;

    //<editor-fold desc="Encapsulation">
    @Null
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (shouldSkip("id"))
            return;
        this.id = id;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (shouldSkip("type"))
            return;
        this.type = type;
    }

    @NotNull
    @Pattern(regexp="[A-Z]{3}-[0-9]{5}")
    @UniqueCode
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (shouldSkip("code"))
            return;
        this.code = code;
    }

    @NotNull
    @Min(1)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (shouldSkip("price"))
            return;
        this.price = price;
    }
    //</editor-fold>
}
