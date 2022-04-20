package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.ReviewDto;
import edu.miu.shopmartbackend.repo.ProductRepo;
import edu.miu.shopmartbackend.repo.ReviewRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.ReviewService;
import edu.miu.shopmartbackend.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ListMapper listMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ReviewDto> getAllReviews() {

        return (List<ReviewDto>) listMapper.mapList(reviewRepo.findAll(),  new ReviewDto());
    }

    @Override
    public ReviewDto getReviewById(long id) {
        return modelMapper.map(reviewRepo.findById(id).get(), ReviewDto.class);
    }

    @Override
    public Review approveReview(long id) {
        Review review = modelMapper.map(getReviewById(id), Review.class);
        review.setApproved(true);
        return reviewRepo.save(review);    }

    @Override
    public Review addReviewByBuyerId(Review review, long id, long productId) {
        User buyer = userRepo.findById(id).orElse(null);
        Product product = productRepo.findById(productId).get();
        if(review.isApproved()) {
            review.setBuyer(buyer);
            review.setProduct(product);
            return reviewRepo.save(review);
        }
        return null;
    }
}
