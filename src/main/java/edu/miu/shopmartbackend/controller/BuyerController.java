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
