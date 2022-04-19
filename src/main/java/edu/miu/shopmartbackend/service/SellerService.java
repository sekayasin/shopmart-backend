package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.users.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();

    Seller getSellerById(long id);

    Seller addSeller(Seller seller);

    void deleteSeller(long id);

    List<Product> findProducts(long id);

    Product addProduct(Product product, long id);


    Seller approveSeller(long id);
}
