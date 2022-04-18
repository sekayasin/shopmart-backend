package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.users.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long > {
    ShoppingCart findShoppingCartByBuyer(Buyer buyer);
    ShoppingCart findFirstByBuyer(Buyer buyer);
}
