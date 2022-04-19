package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.*;

import java.util.List;

public interface BuyerService {


//can be on order controller findOrderByUserId
//    List<Orders> findBuyerOrdersById(long id);//buyer


    //can be on review controller
//    Review addReviewByBuyer(Review review, long buyer_id, long productId);//review
//    List<Review> findReviewsByBuyerId(long id);//buyer


//    Address addAddressOfBuyer(Address address, long id);//buyer
//


    List<Product> findOrCreateShoppingCart(long id);//buyer

    List<Product> addProductsToCart(List<Product> products, long id);

    List<Product> clearShoppingCart(long id);

    List<User> followSeller(long buyer_id, User seller);

    List<User> unFollowSeller(long id, long seller_id);

    Boolean isFollowing(long buyer_id, long seller_id);
}
