package com.zerobase.tablereservation.service;

import com.zerobase.tablereservation.model.Review;
import com.zerobase.tablereservation.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Review registerReview(String comment){
        Review review=new Review();

        review.setComment(comment);

        reviewRepository.save(review);


        return review;
    }

    @Transactional(readOnly = true) // 모든 리뷰 읽기
    public List<Review> readReviews(){
        return reviewRepository.findAll();
    }


}
