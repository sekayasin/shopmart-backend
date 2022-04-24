package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.CustomerOrder;
import edu.miu.shopmartbackend.model.dto.OrderDto;
import edu.miu.shopmartbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed("BUYER")
    @PostMapping
    CustomerOrder saveOrder(@RequestBody CustomerOrder orders){

        return orderService.saveOrder(orders);
    }

    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed("BUYER")
    @GetMapping("/{id}")
    OrderDto findOrderById(@PathVariable("id") long id){
        return orderService.findOrderById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed("BUYER")
    @DeleteMapping("/{orderId}")
    CustomerOrder cancelOrder(@PathVariable long orderId){
        return orderService.cancelOrder(orderId);
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
    @RolesAllowed("BUYER")
    @PatchMapping("/{id}/placed")
    OrderDto placeOrder (@PathVariable("id") long id){
        return orderService.placeOrder(id);
    }
}
