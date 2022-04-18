package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Role;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.UsernamePassDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

   List<User> getAllUsers();

    User getUserById(long id);

    void addUser(UsernamePassDto user);

    void deleteUser(long id);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
