package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.service.BuyerService;
import edu.miu.shopmartbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyers")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @Autowired
    UserService userService;


    @PatchMapping("/{id}/cart")
    List<Product> findOrCreateShoppingCart(@PathVariable long id) {

        return buyerService.findOrCreateShoppingCart(id);
    }

    @PostMapping({"/{buyerid}/products"})
    List<Product> addProductsToCart(@RequestBody List<Product> products, @PathVariable("buyerid") long id) {

        return buyerService.addProductsToCart(products, id);
    }

    @PatchMapping("/{buyerid}")
    List<Product> clearShoppingCart(@PathVariable long id) {

        return buyerService.clearShoppingCart(id);
    }


    @PatchMapping("{buyer_id}/{seller_id}/follow")
   void followSeller(@PathVariable("buyer_id") long buyer_id, @PathVariable long seller_id){

         buyerService.followSeller(buyer_id, seller_id);
    }
    @PatchMapping("/{buyer_id}/{seller_id}/unfollow")
   void unFollowSeller(@PathVariable long buyer_id, @PathVariable long seller_id){

         buyerService.unFollowSeller(buyer_id, seller_id);
    }

    @PatchMapping("/{buyer_id}/{seller_id}/check")
    Boolean isFollowing(@PathVariable long buyer_id, @PathVariable long seller_id){

        return buyerService.isFollowing(buyer_id, seller_id);
    }
}
