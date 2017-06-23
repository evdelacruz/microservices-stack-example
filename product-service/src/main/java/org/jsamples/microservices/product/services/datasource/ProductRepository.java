package org.jsamples.microservices.product.services.datasource;

import org.jsamples.microservices.product.services.datasource.domain.Product;
import java.util.Optional;
import java.util.stream.Stream;

public interface ProductRepository {

    Product save(Product product);

    boolean delete(int id);

    boolean existCode(String code);

    Optional<Product> find(int id);

    Stream<Product> findAll();
}
