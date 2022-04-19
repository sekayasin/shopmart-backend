package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.ShoppingCart;
import edu.miu.shopmartbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart,Long> {

    @Query(value = "select s from ShoppingCart  s where s.user=:user")
    ShoppingCart findShoppingCartByBuyer(User user);

    @Query(value = "select s from ShoppingCart s where s.user=:user")
    ShoppingCart findFirstByBuyer(User user);
}
