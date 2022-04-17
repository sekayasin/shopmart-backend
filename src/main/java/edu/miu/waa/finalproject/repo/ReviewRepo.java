package edu.miu.waa.finalproject.repo;
import edu.miu.waa.finalproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long > {
}
