package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.repo.AddressRepo;
import edu.miu.shopmartbackend.repo.ShoppingCartRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @Override
    public Address addAddressOfBuyer(Address address, long id) {
        User buyer = userRepo.findById(id).orElse(null);
        buyer.setBillingAddress(address);
        return addressRepo.save(address);    }

    @Override
    public List<Address> getAddressesOfBuyer(long id) {
        User buyer = userRepo.findById(id).orElse(null);
        return addressRepo.findAllByBuyer(buyer);    }

    @Override
    public List<Product> findOrCreateShoppingCart(long id) {
        User buyer = userRepo.findById(id).orElse(null);
        ShoppingCart shoppingCart = shoppingCartRepo.findFirstByBuyer(buyer);
        return shoppingCart.getProducts();    }

    @Override
    public List<Product> addProductsToCart(List<Product> products, long id) {
        User buyer = userRepo.findById(id).orElse(null);
        ShoppingCart shoppingCart = shoppingCartRepo.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(products);
        return shoppingCartRepo.save(shoppingCart).getProducts();
    }

    @Override
    public List<Product> clearShoppingCart(long id) {
        User buyer = userRepo.findById(id).orElse(null);
        ShoppingCart shoppingCart = shoppingCartRepo.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(new ArrayList<>());
        return shoppingCartRepo.save(shoppingCart).getProducts();    }

    @Override
    public List<User> followSeller(long buyer_id, User seller) {
        return null;
    }

//    @Override
//    public List<User> followSeller(long buyer_id, long seller_id) {
//        User buyer = userRepo.findById(buyer_id).get();
//        User seller = userRepo.findById(seller_id).get();
//
//        if(buyer == null || seller==null)
//            return null;
//        List<User> sellers =  User.getFollowing();
//        if(sellers == null)
//            sellers = new ArrayList<>();
//        sellers.add(seller);
//        customer.setFollowing((Set<Seller>) sellers);
//        buyerRepository.save(customer);
//        return  sellers;
//    return null;}

    @Override
    public List<User> unFollowSeller(long id, long seller_id) {
//        Buyer customer = buyerRepository.findById(id).get();
//        if(customer == null)
//            throw new UserNotFoundException("Buyer with id of :"+id+" Not found");
//        List<Seller> sellers = (List<Seller>) customer.getFollowing();
//        if(sellers == null)
//            sellers = new ArrayList<>();
//        sellers = sellers.stream().filter(s -> s.getId() != seller_id).collect(Collectors.toList());
//        customer.setFollowing((Set<Seller>) sellers);
//        buyerRepository.save(customer);
//        return sellers;
return null ;
        }

        @Override
        public Boolean isFollowing ( long buyer_id, long seller_id){
//            User buyer = userRepo.findById(id).get();
//            if(buyer == null)
//                throw new RuntimeException();
//            List<Seller> sellers = buyer.getFollowing();
//            if(sellers == null)
//                sellers = new ArrayList<>();
//            Seller seller = sellers.stream().filter(s -> s.getId() == seller_id).findFirst().orElse(null);
//            if(seller == null)
//                return false;
//            return true;      }
            return true;
        }
    }
