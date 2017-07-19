package org.jsamples.microservices.order.services.datasource.impl;

import org.jsamples.microservices.order.services.datasource.OrderRepository;
import org.jsamples.microservices.order.services.datasource.domain.Order;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {
    private Map<Integer, Order> collection;
    private int counter;

    public OrderRepositoryImpl() {
        collection = new ConcurrentHashMap<>(20);
        counter = 0;
    }

    @Override
    public synchronized Order save(Order product) {
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
        return collection.values().stream().anyMatch(order -> order.getCode().equals(code));
    }

    @Override
    public synchronized Optional<Order> find(int id) {
        return collection.values().stream().filter(product -> id == product.getId()).findAny();
    }

    @Override
    public synchronized Stream<Order> findAll() {
        return  collection.values().stream();
    }

    //<editor-fold desc="Support methods">
    private int sequence() {
        return ++counter;
    }
    //</editor-fold>
}
