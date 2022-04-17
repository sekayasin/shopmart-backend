package edu.miu.waa.finalproject.repo;

import edu.miu.waa.finalproject.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long > {
}
