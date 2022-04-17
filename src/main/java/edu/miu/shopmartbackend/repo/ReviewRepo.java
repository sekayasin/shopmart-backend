package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long > {
}
