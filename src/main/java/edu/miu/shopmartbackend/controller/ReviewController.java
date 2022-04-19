package edu.miu.shopmartbackend.controller;

import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin("http://localhost:3001/")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    List<Review> getAllReviews(){
      return   reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    Review getReviewById(@PathVariable long id){
        return reviewService.getReviewById(id);
    }

    @PatchMapping("/{id}/approve")
    Review approveReview(@PathVariable long id){
        return reviewService.approveReview(id);
    }
}