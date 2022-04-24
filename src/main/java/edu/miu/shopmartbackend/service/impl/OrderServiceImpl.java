package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.enums.OrderStatus;
import edu.miu.shopmartbackend.model.CustomerOrder;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.OrderDto;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OrderDto findOrderById(long id) {
        return modelMapper.map(orderRepo.findById(id).get(), OrderDto.class);
    }


    @Override
    public OrderDto placeOrder(long buyer_id) {
        CustomerOrder customerOrder = new CustomerOrder();
        User buyer = userRepo.findById(buyer_id).get();
        ShoppingCart shoppingCart = buyer.getShoppingCart();

        customerOrder.setOrderStatus(OrderStatus.ORDERED);
        customerOrder.setOrderDate(LocalDate.now());
        customerOrder.setShoppingCart(shoppingCart);
//        customerOrder.setUser(buyer);

        double totalPrice =0;
        List<Product> products = shoppingCart.getProducts();

        for (Product p: products){
            totalPrice+=p.getPrice();
        }

        customerOrder.setTotalOrderPrice(totalPrice);

        return modelMapper.map(orderRepo.save(customerOrder), OrderDto.class);

    }

    @Override
    public OrderDto shipOrder(long orderId) {

        CustomerOrder orders = modelMapper.map(findOrderById(orderId), CustomerOrder.class);
//        List<Product> products = orders.getProducts();
//       products.forEach(p -> p.setPurchased(true));
//
//        Order order = modelMapper.map(findOrderById(orderId), Order.class);
        if (orders.getOrderStatus() == OrderStatus.ORDERED){
            orders.setOrderStatus(OrderStatus.SHIPPED);
        }
        return modelMapper.map(orderRepo.save(orders), OrderDto.class);
    }



    @Override
    public CustomerOrder cancelOrder(long orderId) {
//        Order orders = modelMapper.map(findOrderById(orderId), Order.class);
//        List<Product> products = orders.getProducts();
//        products.forEach(p -> p.setPurchased(false));
//        if(orders.getOrderStatus() == OrderStatus.ORDERED){
//            orders.setOrderStatus(OrderStatus.CANCELLED);
//        }
//        return orderRepo.save(orders);
        return null;
    }


    @Override
    public OrderDto deliverOrder(long orderId) {
        CustomerOrder order = modelMapper.map(findOrderById(orderId), CustomerOrder.class);
        if (order.getOrderStatus() == OrderStatus.SHIPPED){
            order.setOrderStatus(OrderStatus.DELIVERED);
            User user = order.getShoppingCart().get;
           int points =  user.getPoints() + 10;
           user.setPoints(points);
           order.setUser(user);
//        }
//        return modelMapper.map(orderRepo.save(order), OrderDto.class);
        return null;
    }

}
