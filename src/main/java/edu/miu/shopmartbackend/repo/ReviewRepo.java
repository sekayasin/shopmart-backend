package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.users.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long > {

    @Query(value = "select r from Review  r where r.buyer=:buyer")
    List<Review> findAllByBuyer(Buyer buyer);

    @Query(value = "select r from Review r where r.product=:product")
    List<Review> findAllByProduct(Product product);
}
