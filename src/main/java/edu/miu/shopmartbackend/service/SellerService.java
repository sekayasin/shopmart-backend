package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Product;

import java.util.List;

public interface SellerService {


    //both can be findProductsByuserId?
        List<Product> findProducts(long id);//seler

         Product addProduct(Product product, long id);//seler
}
