package org.jsamples.microservices.order.controllers;

import org.jsamples.microservices.order.services.OrderService;
import org.jsamples.microservices.order.services.contract.vo.OrderVO;
import org.jsamples.microservices.seedwork.controllers.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path="/orders")
public class OrderController extends Controller<OrderService> {

    public OrderController() {}

    @GetMapping
    public ResponseEntity<?> loadAll() {
        return this.get(OrderService::loadAll);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid OrderVO order) {
        return this.create(service -> service.add(order));
    }
}
