package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.dto.ProductDto;

import java.util.List;

public interface ProductService {


     void saveProduct(Product product, long seller_id);

    List<ProductDto> getAllProducts();

    void deleteProduct(long id);

    ProductDto getProductById(long id);

    void updateProduct(Product product, long id);
}

