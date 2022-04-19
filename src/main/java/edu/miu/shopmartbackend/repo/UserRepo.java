package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long > {
    @Query(value = "select u from User u where u.username=:username")
    Optional<User> findByUsername(String username);
    User getUserById(long id);

}
