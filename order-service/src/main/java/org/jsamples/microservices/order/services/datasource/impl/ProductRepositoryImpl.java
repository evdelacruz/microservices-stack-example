package org.jsamples.microservices.order.services.datasource.impl;

import org.jsamples.microservices.order.services.contract.vo.ProductPriceVO;
import org.jsamples.microservices.order.services.datasource.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
    private static final String URL_BASE = "http://PRODUCT-SERVICE/products";
    private @Autowired RestTemplate restTemplate;

    public ProductRepositoryImpl() {}

    @Override
    public ProductPriceVO getPrice(int id) {
        ResponseEntity<ProductPriceVO> response = restTemplate.getForEntity(URL_BASE+"/"+id, ProductPriceVO.class);
        if (response.getStatusCode().series() != HttpStatus.Series.SUCCESSFUL) {
            throw new IllegalArgumentException("No product found !!!");
        }
        return response.getBody();
    }
}
