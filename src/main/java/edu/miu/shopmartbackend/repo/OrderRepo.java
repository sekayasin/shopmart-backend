package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Long> {

//    @Query(value = "select o from Order  o where o.user=:user")
//     List<Order> findAllByBuyer(User user);

//
//@Query(value="")
//    Orders findFirstByProduct(Product product);
//
//    List<Orders> findAllByProduct(Product product);


}
