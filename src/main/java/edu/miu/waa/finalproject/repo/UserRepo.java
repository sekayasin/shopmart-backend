package edu.miu.waa.finalproject.repo;
import edu.miu.waa.finalproject.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long > {
}
