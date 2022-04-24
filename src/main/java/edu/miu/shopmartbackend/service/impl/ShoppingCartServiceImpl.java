package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.repo.ProductRepo;
import edu.miu.shopmartbackend.repo.ShoppingCartRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ShoppingCartRepo shoppingCartRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public ShoppingCart createShoppingCart(long user_id) {
        ShoppingCart shoppingCart ;
        User buyer = userRepo.getUserById(user_id);
        if (buyer.getShoppingCart() == null){
            shoppingCart = new ShoppingCart();
        }
        else{
            return null;
        }
        buyer.setShoppingCart(shoppingCart);
//        shoppingCart.setBuyer(buyer);
        List<Product> products = new ArrayList<>();
        shoppingCart.setProducts(products);
        return shoppingCartRepo.save(shoppingCart);

    }

//    @Override
//    public ShoppingCart getShoppingCartByBuyerId(long buyer_id) {
//       // User buyer = userRepo.getUserById(buyer_id);
//        return shoppingCartRepo.getShoppingCartByBuyerId(buyer_id);
//    }

    @Override
    public ShoppingCart getShoppingCartById(long cart_id) {
        return shoppingCartRepo.getById(cart_id);
    }

    @Override
    public ShoppingCart addProductToShoppingCart(long buyer_id, long product_id) {
       // User buyer = userRepo.getUserById(buyer_id);
        Product product = productRepo.getById(product_id);
        System.out.println("*********addPRRR**** " + product);
        ShoppingCart shoppingCart = shoppingCartRepo.getById(buyer_id);//getShoppingCart(buyer_id);
        List<Product> products = shoppingCart.getProducts();
        System.out.println("*********addPRRR**** " + product);
        products.add(product);
        shoppingCart.setProducts(products);
        //shoppingCart.setBuyer(buyer);
//        buyer.setShoppingCart(shoppingCart);
        return shoppingCartRepo.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCart(long buyer_id) {
        User buyer = userRepo.getUserById(buyer_id);
       shoppingCartRepo.delete(buyer.getShoppingCart());
    }

    @Override
    public ShoppingCart deleteProductByIdFromCart(long buyer_id, long product_id) {
        Product product = productRepo.getById(product_id);
    User buyer = userRepo.getUserById(buyer_id);
    ShoppingCart shoppingCart = buyer.getShoppingCart();

    List<Product>products = shoppingCart.getProducts();
    products.remove(product);
    shoppingCart.setProducts(products);
    buyer.setShoppingCart(shoppingCart);
    return shoppingCart;
    }


//    @Override
//    public Product addProductToShoppingCart(Product product) {
//        return null;
//    }
//
//    @Override
//    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
//        return null;
//    }
//
//    @Override
//    public void deleteShoppingCart(ShoppingCart shoppingCart) {
//
//    }
}
