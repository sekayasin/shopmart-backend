package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.dto.ProductDto;

import java.util.List;

public interface ProductService {


    public void saveProduct(Product product, long seller_id);

    List<ProductDto> getAllProducts();

    void deleteProduct(long id);

    Product getProductById(long id);

    List<Orders> getOrdersOfProduct(long id);

    void updateProduct(Product product, long id);
}

