package edu.miu.shopmartbackend.service;


import edu.miu.shopmartbackend.model.CustomerOrder;
import edu.miu.shopmartbackend.model.dto.OrderDto;

public interface OrderService {


    OrderDto findOrderById(long id);

    CustomerOrder cancelOrder(long orderId);

    OrderDto shipOrder(long orderId);

    OrderDto deliverOrder(long orderId);

    OrderDto placeOrder (long buyer_id);
}
