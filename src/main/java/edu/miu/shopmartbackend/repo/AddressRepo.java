package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.model.users.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long> {
    List<Address> findAllByBuyer(Buyer buyer);

}
