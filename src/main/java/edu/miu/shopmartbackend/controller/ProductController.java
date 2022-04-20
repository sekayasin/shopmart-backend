package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.ProductDto;
import edu.miu.shopmartbackend.service.OrderService;
import edu.miu.shopmartbackend.service.ProductService;
import edu.miu.shopmartbackend.service.ReviewService;
import edu.miu.shopmartbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/{seller_id}")
    public void saveProduct(@RequestBody ProductDto productDto, @PathVariable long seller_id){
        User seller = userService.getUserById(seller_id);

        if (seller.isAproved()) {
            Product product = modelMapper.map(productDto, Product.class);
            Product newProduct = new Product();
            newProduct.setProductName(product.getProductName());
            newProduct.setDescription(product.getDescription());
            newProduct.setPrice(product.getPrice());
            newProduct.setReviews(null);
             productService.saveProduct(newProduct, seller_id);
        }


    }

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    @GetMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable("id") long id){
        productService.updateProduct(product,id);

    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}/orders")
    public List<Orders> getOrdersOfProduct(@PathVariable("id") long id){
        return productService.getOrdersOfProduct(id);
    }

}
