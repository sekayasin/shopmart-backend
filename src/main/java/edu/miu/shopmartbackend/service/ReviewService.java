package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(long id);

    Review approveReview(long id);
}
