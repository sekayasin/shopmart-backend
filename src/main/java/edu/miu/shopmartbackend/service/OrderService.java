package edu.miu.shopmartbackend.service;


import edu.miu.shopmartbackend.model.Orders;

public interface OrderService {

    Orders saveOrder(Orders orders);

    Orders findOrderById(long id);

    Orders cancelOrder(long orderId);

    Orders shipOrder(long orderId);

    Orders deliverOrder(long orderId);

    Orders placeOrder (long id);
}
