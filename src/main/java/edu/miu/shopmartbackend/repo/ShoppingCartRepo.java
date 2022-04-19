package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.users.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long > {

    @Query(value = "select s from ShoppingCart s where s.buyer=:buyer")
    ShoppingCart findShoppingCartByBuyer(Buyer buyer);

    @Query(value = "select s from ShoppingCart s where s.buyer=:buyer")
    ShoppingCart findFirstByBuyer(Buyer buyer);
}
