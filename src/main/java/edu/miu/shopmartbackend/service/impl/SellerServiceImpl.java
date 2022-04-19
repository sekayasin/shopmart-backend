package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Override
    public List<Product> findProducts(long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product, long id) {
        return null;
    }
}
