package org.jsamples.microservices.product.services.datasource.impl;

import org.jsamples.microservices.product.services.datasource.ProductRepository;
import org.jsamples.microservices.product.services.datasource.domain.Product;
import org.jsamples.microservices.seedwork.repository.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository("productRepository")
public class ProductRepositoryImpl extends Repository implements ProductRepository {
    private Map<Integer, Product> collection;
    private int counter;

    public ProductRepositoryImpl() {
        collection = new ConcurrentHashMap<>(20);
        counter = 0;
    }

    @Override
    public synchronized Product save(Product product) {
        int id = this.sequence();
        product.setId(id);
        collection.put(id, product);
        return product;
    }

    @Override
    public synchronized boolean delete(int id) {
        return collection.remove(id) != null;
    }

    @Override
    public synchronized boolean existCode(String code) {
        return collection.values().stream().anyMatch(product -> product.getCode().equals(code));
    }

    @Override
    public synchronized Optional<Product> find(int id) {
        return collection.values().stream().filter(product -> id == product.getId()).findAny();
    }

    @Override
    public synchronized Stream<Product> findAll() {
        return  collection.values().stream();
    }

    //<editor-fold desc="Support methods">
    private int sequence() {
        return ++counter;
    }
    //</editor-fold>
}
