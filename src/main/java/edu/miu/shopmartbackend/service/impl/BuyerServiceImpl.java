package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.*;
import edu.miu.shopmartbackend.model.users.Buyer;
import edu.miu.shopmartbackend.model.users.Seller;
import edu.miu.shopmartbackend.repo.*;
import edu.miu.shopmartbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepo buyerRepo;

    @Autowired
    OrderRepo orderRepo;


    @Autowired
    ProductRepo productRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    ShoppingCartRepo shoppingCartRepo;

    @Override
    public Buyer findBuyerById(long id) {
        return buyerRepo.findById(id).get();
    }

    @Override
    public Buyer addBuyer(Buyer buyer) {
        return buyerRepo.save(buyer);
    }

    @Override
    public List<Orders> findBuyerOrdersById(long id) {
        Buyer buyer = findBuyerById(id);
        return orderRepo.findAllByBuyer(buyer);
    }

    @Override
    public Review addReviewByBuyerId(Review review, long id, long productId) {
        Buyer buyer = findBuyerById(id);
        Product product = productRepo.findById(productId).get();
        review.setBuyer(buyer);
        review.setProduct(product);
        review.setApproved(false);
        return reviewRepo.save(review);
    }

    @Override
    public List<Review> findReviewsByBuyerId(long id) {
        Buyer buyer = findBuyerById(id);
        return reviewRepo.findAllByBuyer(buyer);    }

    @Override
    public Address addAddressToBuyer(Address address, long id) {
        Buyer buyer = findBuyerById(id);
        address.setBuyer(buyer);
        return addressRepo.save(address);    }

    @Override
    public List<Address> getAddressesOfBuyer(long id) {
        Buyer buyer = findBuyerById(id);
        return addressRepo.findAllByBuyer(buyer);    }

    @Override
    public List<Product> findOrCreateShoppingCart(long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartRepo.findFirstByBuyer(buyer);
        return shoppingCart.getProducts();    }

    @Override
    public List<Product> addProductsToCart(List<Product> products, long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartRepo.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(products);
        return shoppingCartRepo.save(shoppingCart).getProducts();    }

    @Override
    public List<Product> clearShoppingCart(long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartRepo.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(new ArrayList<>());
        return shoppingCartRepo.save(shoppingCart).getProducts();    }

    @Override
    public List<Seller> followSeller(long id, Seller seller) {
        Buyer buyer = buyerRepo.findById(id).get();
        if(buyer == null)
            throw new RuntimeException();
        List<Seller> sellers = (List<Seller>) buyer.getFollowing();
        if(sellers == null)
            sellers = new ArrayList<>();
        sellers.add(seller);
        buyer.setFollowing( sellers);
        buyerRepo.save(buyer);
        return  sellers;    }

    @Override
    public List<Seller> unFollowSeller(long id, long seller_id) {
        Buyer buyer = buyerRepo.findById(id).get();
        if(buyer == null)
            throw new RuntimeException();
        List<Seller> sellers = buyer.getFollowing();
        if(sellers == null)
            sellers = new ArrayList<>();
        sellers = sellers.stream().filter(s -> s.getId() != seller_id).collect(Collectors.toList());
        buyer.setFollowing( sellers);
        buyerRepo.save(buyer);
        return sellers;    }

    @Override
    public Boolean isFollowing(long id, long seller_id) {
        Buyer buyer = buyerRepo.findById(id).get();
        if(buyer == null)
            throw new RuntimeException();
        List<Seller> sellers = buyer.getFollowing();
        if(sellers == null)
            sellers = new ArrayList<>();
        Seller seller = sellers.stream().filter(s -> s.getId() == seller_id).findFirst().orElse(null);
        if(seller == null)
            return false;
        return true;    }
}
