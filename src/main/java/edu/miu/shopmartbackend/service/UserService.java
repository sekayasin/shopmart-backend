package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.*;
import edu.miu.shopmartbackend.model.dto.ReviewDto;
import edu.miu.shopmartbackend.model.dto.UserDto;
import edu.miu.shopmartbackend.model.dto.UsernamePassDto;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {

    UserDto getUserByUsername(String username);

   List<UserDto> getAllUsers();

    List<UserDto> getAllSellers();

    List<UserDto> getAllBuyers();

    UserDto getUserById(long id);

    void addUser(UsernamePassDto user);

    void deleteUser(long id);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);

    UserDto approveSeller(long id);

    ReviewDto approveReview(@PathVariable long review_id);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
