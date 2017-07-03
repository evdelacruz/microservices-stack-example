package org.jsamples.microservices.product.services.impl;

import org.jsamples.microservices.product.services.ProductService;
import org.jsamples.microservices.product.services.contract.vo.ProductCriteriaVO;
import org.jsamples.microservices.product.services.datasource.ProductRepository;
import org.jsamples.microservices.product.services.datasource.domain.Product;
import org.jsamples.microservices.product.services.contract.ProductMapper;
import org.jsamples.microservices.product.services.contract.vo.ProductUpdateVO;
import org.jsamples.microservices.product.services.contract.vo.ProductVO;
import org.jsamples.microservices.seedwork.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service("productService")
public class ProductServiceImpl extends AbstractService implements ProductService {
    private @Autowired ProductRepository productRepository;

    public ProductServiceImpl() {}

    @Override
    public int add(ProductVO product) {
        return productRepository.save(ProductMapper.map(product)).getId();
    }

    @Override
    public void update(ProductUpdateVO update) {
        this.update(update.getId(), product ->
            product.setPrice(update.getPrice())
        );
    }

    @Override
    public void remove(int id) {
        Product product = productRepository.find(id).orElseThrow(IllegalArgumentException::new);
        productRepository.delete(product.getId());
    }

    @Override
    public ProductVO load(int id) {
        return productRepository.find(id).map(ProductMapper::map).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<ProductVO> loadAll(ProductCriteriaVO criteria) {
        return productRepository.findAll()
                .map(product -> ProductMapper.map(product, criteria.toVO()))
                .collect(Collectors.toList());
    }

    //<editor-fold desc="Support methods">
    private void update(int id, Consumer<Product> actualization) {
        actualization.accept(productRepository.find(id).orElseThrow(IndexOutOfBoundsException::new));
    }
    //</editor-fold>
}
