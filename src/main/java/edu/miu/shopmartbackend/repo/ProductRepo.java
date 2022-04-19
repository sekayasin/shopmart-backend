package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.users.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long > {
    List<Product> findAllBySeller(Seller seller);

}
