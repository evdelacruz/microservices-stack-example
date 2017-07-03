package org.jsamples.microservices.product.controllers;

import org.jsamples.microservices.product.services.ProductService;
import org.jsamples.microservices.product.services.contract.vo.ProductCriteriaVO;
import org.jsamples.microservices.product.services.contract.vo.ProductUpdateVO;
import org.jsamples.microservices.product.services.contract.vo.ProductVO;
import org.jsamples.microservices.seedwork.controllers.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController extends Controller<ProductService> {

    public ProductController() {}

    @GetMapping
    public ResponseEntity<?> loadAll(ProductCriteriaVO criteria) {
        return this.get(service -> service.loadAll(criteria));
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid ProductVO product, UriComponentsBuilder builder) {
        return this.create(service -> service.add(product), builder.path("/products/{id}"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> load(@PathVariable int id) {
        return this.get(service -> service.load(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody @Valid ProductUpdateVO update) {
        return this.perform(service -> {
            update.setId(id);
            service.update(update);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable int id) {
        return this.perform(service -> service.remove(id));
    }
}
