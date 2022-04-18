package edu.miu.shopmartbackend.repo;

import edu.miu.shopmartbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
