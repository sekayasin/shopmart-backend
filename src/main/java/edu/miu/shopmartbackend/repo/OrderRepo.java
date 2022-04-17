package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Orders, Long > {
}
