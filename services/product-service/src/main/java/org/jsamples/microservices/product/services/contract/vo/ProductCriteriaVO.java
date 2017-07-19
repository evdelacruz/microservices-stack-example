package org.jsamples.microservices.product.services.contract.vo;

import org.jsamples.microservices.seedwork.binding.vo.Criteria;

public class ProductCriteriaVO extends Criteria {

    public ProductVO toVO() {
        ProductVO vo =  new ProductVO();
        vo.setFields(this.getFields());
        return vo;
    }
}
