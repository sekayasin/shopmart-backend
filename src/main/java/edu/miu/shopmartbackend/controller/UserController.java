package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.UsernamePassDto;
import edu.miu.shopmartbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/name")
    public User getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UsernamePassDto user) {
         userService.addUser(user);
    }

     @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/{seller_id}")
    User approveSeller( @PathVariable long seller_id){
        return userService.approveSeller(seller_id);
    }

    @PatchMapping("/{seller_id}")
    Review approveReview(@PathVariable long review_id){
        return userService.approveReview(review_id);
    }
}



