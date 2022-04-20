package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Product;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SellerController {

    List<Product> findProducts(long id){
        return null;
    }

    Product addProduct(Product product, long id){
        return null;
    }
}
