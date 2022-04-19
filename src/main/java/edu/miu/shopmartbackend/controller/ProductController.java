package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.service.OrderService;
import edu.miu.shopmartbackend.service.ProductService;
import edu.miu.shopmartbackend.service.ReviewService;
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

    @PostMapping
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);

    }

    @GetMapping
    public List<Product> getAllProducts(){
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




