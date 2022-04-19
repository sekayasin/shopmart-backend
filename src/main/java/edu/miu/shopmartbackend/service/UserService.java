package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.*;
import edu.miu.shopmartbackend.model.dto.UsernamePassDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

   List<User> getAllUsers();

    User getUserById(long id);

    void addUser(UsernamePassDto user);

    void deleteUser(long id);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);

        User approveSeller(long id);

    Review approveReview( @PathVariable long review_id);




}
