package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Order;
import edu.miu.shopmartbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    @Query(value = "select o from Order  o where o.user=:user")
     List<Order> findAllByBuyer(User user);

//
//@Query(value="")
//    Orders findFirstByProduct(Product product);
//
//    List<Orders> findAllByProduct(Product product);


}
