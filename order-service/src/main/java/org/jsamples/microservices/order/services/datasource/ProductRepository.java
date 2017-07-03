package org.jsamples.microservices.order.services.datasource;

import org.jsamples.microservices.order.services.contract.vo.ProductPriceVO;

public interface ProductRepository {

    ProductPriceVO getPrice(int id);
}
