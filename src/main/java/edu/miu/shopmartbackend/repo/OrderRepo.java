package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Long> {

}
