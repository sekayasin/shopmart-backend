package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.repo.ProductRepo;
import edu.miu.shopmartbackend.repo.ReviewRepo;
import edu.miu.shopmartbackend.service.ProductService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public void saveProduct(Product product) {productRepo.save(product);}

    @Override
    public List<Product> getAllProducts() {return productRepo.findAll();}

    @Override
    public void deleteProduct(long id) {
        Product product = getProductById(id);
        Orders order = orderRepo.findFirstByProduct(product);

        if(order != null) {
            productRepo.deleteById(id);
        }
    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Orders> getOrdersOfProduct(long id) {
        Product product = getProductById(id);
        return orderRepo.findAllByProduct(product);
    }

    @Override
    public void updateProduct(Product product, long id) {
        Product toBeUpdated = getProductById(id);
        productRepo.save(toBeUpdated);
    }



    @GetMapping("/{id}/reviews")
    public List<Review> getReviewsOfProduct(@PathVariable("id") long id){
        Product product = getProductById(id);
        return reviewRepo.findAllByProduct(product);
    }

}
