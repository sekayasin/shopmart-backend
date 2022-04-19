package edu.miu.shopmartbackend.repo;
import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    List<Address> findAllByBuyer(User buyer);

}
