package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long > {

    @Query(value= "select p from Product p where p.id=:id")
    List<Review> getReviewOfProduct(long id);
}