package com.example.demo.controller;

import com.example.demo.controller.rq.CreateReviewRequest;
import com.example.demo.controller.rq.UpdateReviewRequest;
import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review/create")

    public Review createReview(@RequestBody CreateReviewRequest request) {
        Review createdReview = reviewService.createReview(request);
        return createdReview;
    }

    @PostMapping("/review/update")
    public ResponseEntity<String> updateReview(@RequestBody UpdateReviewRequest request) {
        reviewService.updateReview(request);
        return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
    }

    @PostMapping("/review/deleteLast")
    public ResponseEntity<String> deleteLastReview() {
        reviewService.deleteLastReview();
        return ResponseEntity.ok("Last review deleted successfully");
    }
}

