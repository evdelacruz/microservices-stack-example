package org.jsamples.microservices.product.services;

import org.jsamples.microservices.product.services.contract.vo.ProductCriteriaVO;
import org.jsamples.microservices.product.services.contract.vo.ProductUpdateVO;
import org.jsamples.microservices.product.services.contract.vo.ProductVO;
import org.jsamples.microservices.seedwork.service.Service;
import java.util.List;

public interface ProductService extends Service {

    int add(ProductVO product);

    void update(ProductUpdateVO update);

    void remove(int id);

    ProductVO load(int id);

    List<ProductVO> loadAll(ProductCriteriaVO criteria);
}
