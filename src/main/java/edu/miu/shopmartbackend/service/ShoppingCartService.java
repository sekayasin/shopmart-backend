package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    ShoppingCart createShoppingCart(long user_id);

//    ShoppingCart getShoppingCartByBuyerId(long buyer_id);

    ShoppingCart getShoppingCartById(long cart_id);

    ShoppingCart addProductToShoppingCart(long buyer_id, long product_id);

    void deleteShoppingCart(long buyer_id);

    ShoppingCart deleteProductByIdFromCart(long buyer_id, long product_id);




//    Product addProductToShoppingCart(Product product);
//
//    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
//
//    void deleteShoppingCart(ShoppingCart shoppingCart);
}
