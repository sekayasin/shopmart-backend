package edu.miu.waa.finalproject.repo;
import edu.miu.waa.finalproject.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long > {
}
