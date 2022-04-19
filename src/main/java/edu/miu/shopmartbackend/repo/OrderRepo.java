package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

    @Query(value = "select o from Orders  o where o.user=:user")
     List<Orders> findAllByBuyer(User user);

//
//@Query(value="")
//    Orders findFirstByProduct(Product product);
//
//    List<Orders> findAllByProduct(Product product);


}
