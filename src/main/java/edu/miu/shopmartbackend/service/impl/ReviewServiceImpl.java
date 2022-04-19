package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.repo.ReviewRepo;
import edu.miu.shopmartbackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public Review approveReview(long id) {
        Review review = getReviewById(id);
        review.setApproved(true);
        return reviewRepo.save(review);    }
}
