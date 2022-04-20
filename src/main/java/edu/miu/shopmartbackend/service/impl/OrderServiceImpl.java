package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.enums.OrderStatus;
import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Orders findOrderById(long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public Orders saveOrder(Orders order) {
        double totalPrice=0;
        List<Product> products = order.getProducts();
        for(Product p : products){
            totalPrice += p.getPrice();
            order.setTotalOrderPrice(totalPrice);
        }
        order.setOrderStatus(OrderStatus.CREATED);
        return orderRepo.save(order);
    }

    @Override
    public Orders placeOrder(long id) {
        Orders order = findOrderById(id);
        if (order.getOrderStatus() == OrderStatus.CREATED){
            order.setOrderStatus(OrderStatus.ORDERED);
        }
        //void makePayment()

        return orderRepo.save(order);
    }

    @Override
    public Orders shipOrder(long orderId) {
        Orders orders = findOrderById(orderId);
        List<Product> products = orders.getProducts();
       products.forEach(p -> p.setPurchased(true));

        Orders order = findOrderById(orderId);
        if (order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.SHIPPED);
        }
        return orderRepo.save(order);
    }

    @Override
    public Orders cancelOrder(long orderId) {
        Orders orders = findOrderById(orderId);
        List<Product> products = orders.getProducts();
        products.forEach(p -> p.setPurchased(false));
        if(orders.getOrderStatus() == OrderStatus.ORDERED){
            orders.setOrderStatus(OrderStatus.CANCELLED);
        }
        return orderRepo.save(orders);
    }


    @Override
    public Orders deliverOrder(long orderId) {
        Orders order = findOrderById(orderId);
        if (order.getOrderStatus() == OrderStatus.SHIPPED){
            order.setOrderStatus(OrderStatus.DELIVERED);
            User user = order.getUser();
           int points =  user.getPoints() + 10;
           user.setPoints(points);
           order.setUser(user);
        }
        return orderRepo.save(order);
    }

}
