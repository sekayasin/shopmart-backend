package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/{buyer_id}")
    public ShoppingCart createShoppingCart(@PathVariable long buyer_id){
        return shoppingCartService.createShoppingCart(buyer_id);
    }

    @GetMapping("/{buyer_id}")
    public ShoppingCart getShoppingCart(@PathVariable long buyer_id) {
       return shoppingCartService.getShoppingCart(buyer_id);
    }

    @GetMapping("/{cart_id}/cart")
    public ShoppingCart getShoppingCartById(long cart_id){
        return shoppingCartService.getShoppingCartById(cart_id);
    }

    @PostMapping("/{buyer_id}/{product_id}")
    public ShoppingCart addProductToShoppingCart(@PathVariable long buyer_id, @PathVariable long product_id){
       return shoppingCartService.addProductToShoppingCart(buyer_id, product_id);
    }

    @DeleteMapping("/{buyer_id}")
    public void deleteShoppingCart(@PathVariable long buyer_id){
        shoppingCartService.deleteShoppingCart(buyer_id);
    }

    @DeleteMapping("/{buyer_id}/{product_id}")
    public ShoppingCart deleteProductByIdFromCart(@PathVariable long buyer_id, @PathVariable long product_id){
        return shoppingCartService.deleteProductByIdFromCart(buyer_id, product_id);
    }








}
