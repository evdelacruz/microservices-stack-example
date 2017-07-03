package org.jsamples.microservices.order.services.contract;

import org.jsamples.microservices.order.services.datasource.domain.Order;
import org.jsamples.microservices.order.services.datasource.domain.Product;
import org.jsamples.microservices.order.services.contract.vo.OrderVO;
import org.jsamples.microservices.order.services.contract.vo.ProductVO;
import java.util.function.Consumer;

public final class OrderMapper {

    static public Order map(OrderVO source, Consumer<Order> setHolderFunction) {
        Order target = null;
        if (null != source) {
            target = new Order();
            target.setPrice(source.getPrice());
            target.setProduct(Product.valueOf(source.getProduct().name()));
            setHolderFunction.accept(target);
        }
        return target;
    }

    static public OrderVO map(Order source, Consumer<OrderVO> setHolderFunction) {
        OrderVO target = null;
        if (null != source) {
            target = new OrderVO();
            target.setId(source.getId());
            target.setPrice(source.getPrice());
            target.setProduct(ProductVO.valueOf(source.getProduct().name()));
            setHolderFunction.accept(target);
        }
        return target;
    }

    private OrderMapper() {}
}
