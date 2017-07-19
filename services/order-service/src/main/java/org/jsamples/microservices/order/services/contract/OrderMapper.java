package org.jsamples.microservices.order.services.contract;

import org.jsamples.microservices.order.services.datasource.domain.Order;
import org.jsamples.microservices.order.services.contract.vo.OrderVO;
import org.jsamples.microservices.seedwork.binding.Mapper;
import org.jsamples.microservices.seedwork.binding.MapperFactory;
import java.util.function.Consumer;

public final class OrderMapper {
    private static final Mapper MAPPER = MapperFactory.getMapper(OrderMapper.class);

    static public Order map(OrderVO source, Consumer<Order> setPriceFunction) {
        Order target = MAPPER.map(source, Order.class);
        setPriceFunction.accept(target);
        return target;
    }

    static public OrderVO map(Order source) {
        return MAPPER.map(source, OrderVO.class);
    }
}
