package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    Product addProductToShoppingCart(Product product);

    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

    void deleteShoppingCart(ShoppingCart shoppingCart);
}
