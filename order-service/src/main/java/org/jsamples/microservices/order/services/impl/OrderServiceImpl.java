package org.jsamples.microservices.order.services.impl;

import org.jsamples.microservices.order.services.OrderService;
import org.jsamples.microservices.order.services.contract.vo.ProductPriceVO;
import org.jsamples.microservices.order.services.datasource.OrderRepository;
import org.jsamples.microservices.order.services.contract.OrderMapper;
import org.jsamples.microservices.order.services.contract.vo.OrderVO;
import org.jsamples.microservices.order.services.datasource.ProductRepository;
import org.jsamples.microservices.seedwork.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class OrderServiceImpl extends AbstractService implements OrderService {
    private @Autowired OrderRepository orderRepository;
    private @Autowired ProductRepository productRepository;
    private @Value("${order.app.rate}") int rate;

    public OrderServiceImpl() {}

    @Override
    public int add(OrderVO vo) {
        return orderRepository.save(OrderMapper.map(vo, order -> {
            ProductPriceVO price = productRepository.getPrice(order.getProductId());
            order.setPrice(price.getPrice() + rate);
        })).getId();
    }

    @Override
    public List<OrderVO> loadAll() {
        return orderRepository.findAll().map(OrderMapper::map).collect(Collectors.toList());
    }
}
