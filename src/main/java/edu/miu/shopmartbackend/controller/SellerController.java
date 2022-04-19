package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.users.Seller;
import edu.miu.shopmartbackend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sellers")
@CrossOrigin("http://localhost:3001/")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping
    List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

@GetMapping("/{id}")
    Seller getSellerById(@PathVariable long id){
        return  sellerService.getSellerById(id);
    }

    @PostMapping
    Seller addSeller(Seller seller){
        return  sellerService.addSeller(seller);}

    @DeleteMapping("/{id}")
    void deleteSeller(@PathVariable long id){
        sellerService.deleteSeller(id);
    }

       @PostMapping("/{seller_id}/products")
    Product addProduct( @RequestBody Product product, @PathVariable long seller_id) {

    Seller seller = getSellerById(seller_id);

    if (seller.isApproved()) {
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setReviews(null);
        return sellerService.addProduct(newProduct, seller_id);
    }
    return null;
}

     @PatchMapping("/{seller_id}")
    Seller approveSeller( @PathVariable long seller_id){
        return sellerService.approveSeller(seller_id);
    }
}
