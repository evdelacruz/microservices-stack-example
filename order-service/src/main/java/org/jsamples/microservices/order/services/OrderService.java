package org.jsamples.microservices.order.services;

import org.jsamples.microservices.order.services.contract.vo.OrderVO;
import org.jsamples.microservices.seedwork.service.Service;

import java.util.List;

public interface OrderService extends Service {

    int add(OrderVO order);

    List<OrderVO> loadAll();
}
