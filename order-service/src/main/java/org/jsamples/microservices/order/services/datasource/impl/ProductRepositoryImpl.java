package org.jsamples.microservices.order.services.datasource.impl;

import org.jsamples.microservices.order.services.datasource.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
    private @Autowired RestTemplate restTemplate;

    public ProductRepositoryImpl() {}

    /*public int add() {
        try {
            restTemplate.postForEntity(new URI("http://CITIZEN-SERVICE/citizens"), citizen, Void.TYPE);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }*/
}
