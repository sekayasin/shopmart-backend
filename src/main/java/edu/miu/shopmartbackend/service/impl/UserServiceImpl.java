package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.users.User;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "##########serviceImpl");
         userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
     userRepo.deleteById(id);
    }
}
