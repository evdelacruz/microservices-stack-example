package org.jsamples.microservices.product.services.impl;

import org.jsamples.microservices.product.services.ProductService;
import org.jsamples.microservices.product.services.datasource.ProductRepository;
import org.jsamples.microservices.product.services.datasource.domain.Product;
import org.jsamples.microservices.product.services.vo.ProductMapper;
import org.jsamples.microservices.product.services.vo.map.ProductListVO;
import org.jsamples.microservices.product.services.vo.map.ProductUpdateVO;
import org.jsamples.microservices.product.services.vo.map.ProductVO;
import org.jsamples.microservices.seedwork.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service("productService")
public class ProductServiceImpl extends BaseService implements ProductService {
    private @Autowired ProductRepository productRepository;

    public ProductServiceImpl() {}

    @Override
    public Product add(ProductVO product) {
        if (productRepository.existCode(product.getCode())) {
            throw new IllegalArgumentException("Repeteated code !!!");
        }
        return productRepository.save(ProductMapper.map(product));
    }

    @Override
    public void update(ProductUpdateVO update) {
        this.update(update.getId(), product ->
            product.setPrice(update.getPrice())
        );
    }

    @Override
    public boolean remove(int id) {
        return productRepository.delete(id);
    }

    @Override
    public ProductVO load(int id) {
        Product product = productRepository.find(id).orElseThrow(IndexOutOfBoundsException::new);
        return ProductMapper.map(product);
    }

    @Override
    public List<ProductListVO> loadAll() {
        return productRepository.findAll().map(ProductMapper::mapList).collect(Collectors.toList());
    }

    //<editor-fold desc="Support methods">
    private void update(int id, Consumer<Product> actualization) {
        actualization.accept(productRepository.find(id).orElseThrow(IndexOutOfBoundsException::new));
    }
    //</editor-fold>
}
