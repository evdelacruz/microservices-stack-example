package org.jsamples.microservices.product.controllers;

import org.jsamples.microservices.product.services.ProductService;
import org.jsamples.microservices.product.services.vo.map.ProductListVO;
import org.jsamples.microservices.product.services.vo.map.ProductUpdateVO;
import org.jsamples.microservices.product.services.vo.map.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final ResponseEntity<Void> NO_CONTENT = ResponseEntity.noContent().build();
    private @Autowired ProductService productService;

    public ProductController() {}

    @RequestMapping(method=RequestMethod.GET)
    public List<ProductListVO> getAll() {
        return productService.loadAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody @Valid ProductVO product, UriComponentsBuilder builder) {
        UriComponents uri = builder.path("/products/{id}").buildAndExpand(productService.add(product).getId());
        return ResponseEntity.created(uri.toUri()).build();
    }

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ProductVO get(@PathVariable int id) {
        return productService.load(id);
    }

    @RequestMapping(path="/{id}", method=RequestMethod.PATCH)
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody @Valid ProductUpdateVO update) {
        update.setId(id);
        productService.update(update);
        return NO_CONTENT;
    }

    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> remove(@PathVariable int id) {
        productService.remove(id);
        return NO_CONTENT;
    }
}
