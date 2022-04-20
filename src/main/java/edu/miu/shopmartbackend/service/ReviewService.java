package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getAllReviews();

    ReviewDto getReviewById(long id);

    Review approveReview(long id);

    Review addReviewByBuyerId(Review review, long id, long productId);//review

}
