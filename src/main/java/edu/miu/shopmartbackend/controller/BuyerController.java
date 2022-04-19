package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.users.Buyer;
import edu.miu.shopmartbackend.model.users.Seller;
import edu.miu.shopmartbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyers")
@CrossOrigin("http://localhost:3001")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @GetMapping("/{id}")
    Buyer findBuyerById( @PathVariable  long id){

        return buyerService.findBuyerById(id);
    }
     @PostMapping
    Buyer addBuyer( @RequestBody Buyer buyer){

        return buyerService.addBuyer(buyer);
    }
  @GetMapping("/{id}/orders")
    List<Orders> findBuyerOrdersById(long id){

        return buyerService.findBuyerOrdersById(id);
    }
     @PostMapping("/{buyerId}/{productId}")
    Review addReviewByBuyerId(@RequestBody Review review, @PathVariable long buyerId, @PathVariable long productId){
        return buyerService.addReviewByBuyerId(review,buyerId,productId);
    }
    @GetMapping("/{id}/reviews")
    List<Review> findReviewsByBuyerId(@PathVariable long id){

        return buyerService.findReviewsByBuyerId(id);
    }

    @PostMapping("/{id}/address")
    Address addAddressToBuyer(@RequestBody Address address, @PathVariable long id){
        return buyerService.addAddressToBuyer(address, id);
    }

    @GetMapping("/{id}/address")
    List<Address> getAddressesOfBuyer(@PathVariable long id){

        return buyerService.getAddressesOfBuyer(id);
    }

    @PatchMapping("/{id}/cart")
    List<Product> findOrCreateShoppingCart(@PathVariable  long id){

        return buyerService.findOrCreateShoppingCart(id);
    }

    @PostMapping({"/{buyerid}/products"})
    List<Product> addProductsToCart(@RequestBody List<Product> products, @PathVariable("buyerid") long id){

        return buyerService.addProductsToCart(products, id);
    }
    @PatchMapping("/{buyerid}")
    List<Product> clearShoppingCart(@PathVariable long id){

        return buyerService.clearShoppingCart(id);
    }

    @PatchMapping("{buyer_id}/follow")
    List<Seller> followSeller(@PathVariable("buyer_id") long id, @RequestBody Seller seller){

        return buyerService.followSeller(id, seller);
    }
     @PatchMapping("/{buyer_id}/{seller_id}/unfollow")
    List<Seller> unFollowSeller(@PathVariable long buyer_id, @PathVariable long seller_id){

        return buyerService.unFollowSeller(buyer_id, seller_id);
    }

    @PatchMapping("/{buyer_id}/{seller_id}/check")
    Boolean isFollowing(@PathVariable long buyer_id, @PathVariable long seller_id){

        return buyerService.isFollowing(buyer_id, seller_id);
    }
}
