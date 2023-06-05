package com.zerobase.tablereservation.controller;

import com.zerobase.tablereservation.model.Review;
import com.zerobase.tablereservation.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create/review") //리뷰 등록
    public void registerReview(@RequestBody String comment){

        reviewService.registerReview(comment);

    }

    @GetMapping("/read/reviews")
    public List<Review> readReviews(){

        return reviewService.readReviews();

    }




}