package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("http://localhost:3001/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Orders saveOrder(@RequestBody Orders orders){
        return orderService.saveOrder(orders);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    Orders findOrderById(@PathVariable("id") long id){
        return orderService.findOrderById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{orderId}")
    Orders cancelOrder(@PathVariable long orderId){
        return orderService.cancelOrder(orderId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{orderId}/ship")
    Orders shipOrder(@PathVariable("orderId") long orderId){
        return orderService.shipOrder(orderId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{orderId}/deliver")
    Orders deliverOrder(@PathVariable("orderId") long orderId){
        return orderService.deliverOrder(orderId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/placed")
    Orders placeOrder (@PathVariable("id") long id){
        return orderService.placeOrder(id);
    }
}
