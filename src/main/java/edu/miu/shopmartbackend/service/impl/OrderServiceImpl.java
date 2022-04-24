package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.enums.OrderStatus;
import edu.miu.shopmartbackend.model.CustomerOrder;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.OrderDto;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.InvoiceService;
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

    @Autowired
    InvoiceService invoiceService;

    @Override
    public OrderDto findOrderById(long order_id) {
        return modelMapper.map(orderRepo.findById(order_id).get(), OrderDto.class);
    }


    @Override
    public OrderDto placeOrder(long buyer_id) {
        CustomerOrder customerOrder = new CustomerOrder();
        User buyer = userRepo.findById(buyer_id).get();
        ShoppingCart shoppingCart = buyer.getShoppingCart();

        customerOrder.setOrderStatus(OrderStatus.ORDERED);
        customerOrder.setOrderDate(LocalDate.now());
        customerOrder.setShoppingCart(shoppingCart);
        customerOrder.setBuyer(buyer);

        double totalPrice = 0;
        List<Product> products = shoppingCart.getProducts();

        for (Product p : products) {
            totalPrice += p.getPrice();
        }

        invoiceService.payToOrder(totalPrice);
        customerOrder.setTotalOrderPrice(totalPrice);

        return modelMapper.map(orderRepo.save(customerOrder), OrderDto.class);

    }

    @Override
    public OrderDto shipOrder(long orderId) {

        CustomerOrder orders = modelMapper.map(orderRepo.findById(orderId).get(), CustomerOrder.class);
        ShoppingCart shoppingCart = orders.getShoppingCart();

        List<Product> products = shoppingCart.getProducts();
        if(products != null)
        products.forEach(p -> p.setPurchased(true));
//
        shoppingCart.setProducts(products);
        orders.setShoppingCart(shoppingCart);
//        Order order = modelMapper.map(findOrderById(orderId), Order.class);
        if (orders.getOrderStatus() == OrderStatus.ORDERED) {
            orders.setOrderStatus(OrderStatus.SHIPPED);
        }
        return modelMapper.map(orderRepo.save(orders), OrderDto.class);
    }

    @Override
    public OrderDto deliverOrder(long orderId) {
        CustomerOrder order = modelMapper.map(orderRepo.findById(orderId).get(), CustomerOrder.class);
        if (order.getOrderStatus() == OrderStatus.SHIPPED) {
            order.setOrderStatus(OrderStatus.DELIVERED);
        }
        User buyer = order.getBuyer();
        int points = buyer.getPoints() + 10;
        buyer.setPoints(points);
        order.setBuyer(buyer);
        return modelMapper.map(orderRepo.save(order),OrderDto .class);

    }
    @Override
    public OrderDto cancelOrder(long orderId) {
        CustomerOrder orders = modelMapper.map(orderRepo.findById(orderId).get(), CustomerOrder.class);

        ShoppingCart shoppingCart = orders.getShoppingCart();

        List<Product> products = shoppingCart.getProducts();
        if(products != null)
            products.forEach(p -> p.setPurchased(false));

        shoppingCart.setProducts(products);
        orders.setShoppingCart(shoppingCart);

        if (orders.getOrderStatus() == OrderStatus.ORDERED) {
            orders.setOrderStatus(OrderStatus.CANCELLED);
        }
        return modelMapper.map(orderRepo.save(orders), OrderDto.class);
    }



}


