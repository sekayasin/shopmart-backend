package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.users.User;

import java.util.List;

public interface UserService {


    User getUserByUsername(String username);

   List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void deleteUser(long id);

//    User isUsernameAvailable(UserAvailabilityRequest userAvailabilityRequest);
}
