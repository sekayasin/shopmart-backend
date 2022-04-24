package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.ProductDto;
import edu.miu.shopmartbackend.repo.OrderRepo;
import edu.miu.shopmartbackend.repo.ProductRepo;
import edu.miu.shopmartbackend.repo.ReviewRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.ProductService;
import edu.miu.shopmartbackend.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;



    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Product, ProductDto> listMapperToDto;

    @Override
    public void saveProduct(Product product, long seller_id) {
        User seller = userRepo.getUserById(seller_id);
        product.setSeller(seller);
         productRepo.save(product);      }

    @Override
    public List<ProductDto> getAllProducts() {
        return (List<ProductDto>) listMapperToDto.mapList(productRepo.findAll(), new ProductDto());
    }

    @Override
    public void deleteProduct(long id) {
        Product product = modelMapper.map(getProductById(id), Product.class);
        if(product.isPurchased()){
            throw new RuntimeException();
        }
            productRepo.deleteById(id);
      }


    @Override
    public ProductDto getProductById(long id) {
        return modelMapper.map(productRepo.findById(id).get(), ProductDto.class);
    }

    @Override
    public void updateProduct(Product product, long id) {
        Product toBeUpdated =modelMapper.map (getProductById(id), Product.class);
        productRepo.save(toBeUpdated);
    }



    @GetMapping("/{id}/reviews")
    public List<Review> getReviewsOfProduct(@PathVariable("id") long id){
        Product product = modelMapper.map (getProductById(id), Product.class);
        return reviewRepo.findAllByProduct(product);
    }

}
