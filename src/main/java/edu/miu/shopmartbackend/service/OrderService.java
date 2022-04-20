package edu.miu.shopmartbackend.service;


import edu.miu.shopmartbackend.model.Order;
import edu.miu.shopmartbackend.model.dto.OrderDto;

public interface OrderService {

    Order saveOrder(Order orders);

    OrderDto findOrderById(long id);

    Order cancelOrder(long orderId);

    OrderDto shipOrder(long orderId);

    OrderDto deliverOrder(long orderId);

    OrderDto placeOrder (long id);
}
