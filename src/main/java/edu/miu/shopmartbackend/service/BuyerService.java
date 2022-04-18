package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.users.Buyer;
import edu.miu.shopmartbackend.model.users.Seller;

import java.util.List;

public interface BuyerService {
    Buyer findBuyerById(long id);

    Buyer addBuyer(Buyer buyer);

    List<Orders> findBuyerOrdersById(long id);

    Review addReviewByBuyerId(Review review, long id, long productId);

    List<Review> findReviewsByBuyerId(long id);

    Address addAddressToBuyer(Address address, long id);

    List<Address> getAddressesOfBuyer(long id);

    List<Product> findOrCreateShoppingCart(long id);

    List<Product> addProductsToCart(List<Product> products, long id);

    List<Product> clearShoppingCart(long id);

    List<Seller> followSeller(long id, Seller seller);

    List<Seller> unFollowSeller(long id, long seller_id);

    Boolean isFollowing(long id, long seller_id);
}
