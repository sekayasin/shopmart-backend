package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.ReviewDto;
import edu.miu.shopmartbackend.model.dto.UserDto;
import edu.miu.shopmartbackend.model.dto.UsernamePassDto;
import edu.miu.shopmartbackend.service.BuyerService;
import edu.miu.shopmartbackend.service.SellerService;
import edu.miu.shopmartbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final SellerService sellerService;
    private final BuyerService buyerService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/sellers")
    public List<UserDto> getAllSellers() {
        return userService.getAllSellers();
    }

    @GetMapping("/buyers")
    public List<UserDto> getAllBuyers() {
        return userService.getAllBuyers();
    }

    @GetMapping("/name")
    public UserDto getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
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

    @PatchMapping("/{seller_id}/approveseller")
    UserDto approveSeller( @PathVariable long seller_id){
        return userService.approveSeller(seller_id);
    }

    @PatchMapping("/{seller_id}")
    ReviewDto approveReview(@PathVariable long review_id){
        return userService.approveReview(review_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }
}



