package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.dto.OrderDto;
import edu.miu.shopmartbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{buyer_id}/placed")
    OrderDto placeOrder (@PathVariable("buyer_id") long buyer_id){
        return orderService.placeOrder(buyer_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{order_id}")
    OrderDto findOrderById(@PathVariable("order_id") long order_id){
        return orderService.findOrderById(order_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{orderId}/ship")
    OrderDto shipOrder(@PathVariable("orderId") long orderId){
        return orderService.shipOrder(orderId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{orderId}/deliver")
    OrderDto deliverOrder(@PathVariable("orderId") long orderId){
        return orderService.deliverOrder(orderId);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{orderId}")
    OrderDto cancelOrder(@PathVariable long orderId){
        return orderService.cancelOrder(orderId);
    }






}
