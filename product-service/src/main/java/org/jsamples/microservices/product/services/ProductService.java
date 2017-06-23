package org.jsamples.microservices.product.services;

import org.jsamples.microservices.product.services.datasource.domain.Product;
import org.jsamples.microservices.product.services.vo.map.ProductListVO;
import org.jsamples.microservices.product.services.vo.map.ProductUpdateVO;
import org.jsamples.microservices.product.services.vo.map.ProductVO;

import java.util.List;

public interface ProductService {

    Product add(ProductVO product);

    void update(ProductUpdateVO update);

    boolean remove(int id);

    ProductVO load(int id);

    List<ProductListVO> loadAll();
}
