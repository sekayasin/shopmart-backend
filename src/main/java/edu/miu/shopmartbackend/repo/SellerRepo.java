package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.users.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
}
