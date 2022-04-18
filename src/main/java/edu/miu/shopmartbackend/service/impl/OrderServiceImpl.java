package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.enums.OrderStatus;
import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Orders findOrderById(long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public Orders saveOrder(Orders orders) {
        orders.setOrderStatus(OrderStatus.CREATED);
        return orderRepo.save(orders);
    }

    @Override
    public Orders placeOrder(long id) {
        Orders order = findOrderById(id);
        if (order.getOrderStatus() == OrderStatus.CREATED){
            order.setOrderStatus(OrderStatus.ORDERED);
        }
        return orderRepo.save(order);
    }

    @Override
    public Orders shipOrder(long orderId) {
        Orders order = findOrderById(orderId);
        if (order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.SHIPPED);
        }
        return orderRepo.save(order);
    }

    @Override
    public Orders cancelOrder(long orderId) {
        Orders order = findOrderById(orderId);
        if(order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.CANCELLED);
        }
        return orderRepo.save(order);
    }


    @Override
    public Orders deliverOrder(long orderId) {
        Orders order = findOrderById(orderId);
        if (order.getOrderStatus() == OrderStatus.SHIPPED){
            order.setOrderStatus(OrderStatus.DELIVERED);
        }
        return orderRepo.save(order);
    }


}
