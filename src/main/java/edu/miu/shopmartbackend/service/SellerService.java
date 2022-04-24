package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.UserDto;

import java.util.List;

public interface SellerService {
    //both can be findProductsByuserId?
        List<Product> findProducts(long id);//seler

         Product addProduct(Product product, long id);//seler
}
