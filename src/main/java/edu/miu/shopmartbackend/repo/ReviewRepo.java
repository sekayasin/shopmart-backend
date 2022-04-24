package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findAll();
    List<Review> findAllByProduct(Product product);
}
