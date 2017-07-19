package org.jsamples.microservices.order.services.datasource;

import org.jsamples.microservices.order.services.datasource.domain.Order;
import java.util.Optional;
import java.util.stream.Stream;

public interface OrderRepository {

    Order save(Order product);

    boolean delete(int id);

    boolean existCode(String code);

    Optional<Order> find(int id);

    Stream<Order> findAll();
}
