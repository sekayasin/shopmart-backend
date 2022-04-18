package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Role;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.UsernamePassDto;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

   List<User> getAllUsers();

    User getUserById(long id);

    void addUser(UsernamePassDto user);

    void deleteUser(long id);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);
}
