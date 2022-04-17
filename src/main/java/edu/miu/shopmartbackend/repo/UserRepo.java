package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long > {
}
