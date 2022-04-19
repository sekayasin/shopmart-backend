package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.users.Seller;
import edu.miu.shopmartbackend.repo.ProductRepo;
import edu.miu.shopmartbackend.repo.SellerRepo;
import edu.miu.shopmartbackend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepo sellerRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepo.findAll();
    }

    @Override
    public Seller getSellerById(long id) {
        return sellerRepo.getById(id);
    }

    @Override
    public Seller addSeller(Seller seller) {
        seller.setApproved(false);
        return sellerRepo.save(seller);
    }

    @Override
    public void deleteSeller(long id) {
sellerRepo.deleteById(id);
    }

    @Override
    public List<Product> findProducts(long id) {
        return productRepo.findAllBySeller(getSellerById(id));    }

    @Override
    public Product addProduct(Product product, long id) {
        Seller seller = getSellerById(id);
        product.setSellers(seller);
        return productRepo.save(product);    }

    @Override
    public Seller approveSeller(long id) {
        Seller seller = getSellerById(id);
        seller.setApproved(true);
        return sellerRepo.save(seller);    }
}
