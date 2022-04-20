package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.enums.OrderStatus;
import edu.miu.shopmartbackend.model.Order;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.OrderDto;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OrderDto findOrderById(long id) {
        return modelMapper.map(orderRepo.findById(id).get(), OrderDto.class);
    }

    @Override
    public Order saveOrder(Order order) {
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
    public OrderDto placeOrder(long id) {
        Order order = modelMapper.map(findOrderById(id), Order.class);
        if (order.getOrderStatus() == OrderStatus.CREATED){
            order.setOrderStatus(OrderStatus.ORDERED);
        }
        //void makePayment()

        return modelMapper.map(orderRepo.save(order), OrderDto.class);
    }

    @Override
    public OrderDto shipOrder(long orderId) {
        Order orders = modelMapper.map(findOrderById(orderId), Order.class);
        List<Product> products = orders.getProducts();
       products.forEach(p -> p.setPurchased(true));

        Order order = modelMapper.map(findOrderById(orderId), Order.class);
        if (order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.SHIPPED);
        }
        return modelMapper.map(orderRepo.save(order), OrderDto.class);
    }

    @Override
    public Order cancelOrder(long orderId) {
        Order orders = modelMapper.map(findOrderById(orderId), Order.class);
        List<Product> products = orders.getProducts();
        products.forEach(p -> p.setPurchased(false));
        if(orders.getOrderStatus() == OrderStatus.ORDERED){
            orders.setOrderStatus(OrderStatus.CANCELLED);
        }
        return orderRepo.save(orders);
    }


    @Override
    public OrderDto deliverOrder(long orderId) {
        Order order = modelMapper.map(findOrderById(orderId), Order.class);
        if (order.getOrderStatus() == OrderStatus.SHIPPED){
            order.setOrderStatus(OrderStatus.DELIVERED);
            User user = order.getUser();
           int points =  user.getPoints() + 10;
           user.setPoints(points);
           order.setUser(user);
        }
        return modelMapper.map(orderRepo.save(order), OrderDto.class);
    }

}
