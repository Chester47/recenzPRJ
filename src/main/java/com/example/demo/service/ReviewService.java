package com.example.demo.service;

import com.example.demo.controller.rq.CreateReviewRequest;
import com.example.demo.controller.rq.UpdateReviewRequest;
import com.example.demo.entity.Game;
import com.example.demo.entity.Review;
import com.example.demo.repository.Exception.GameNotFoundException;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;

    public Review createReview(CreateReviewRequest request) {
        Review review = new Review();
        review.setText(request.getText());

        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(()
                -> new GameNotFoundException("Game not found"));
        review.setGame(game);

        Review savedReview = reviewRepository.save(review);
        return savedReview;
    }

    public void updateReview(UpdateReviewRequest request) {

        Review review = reviewRepository.findByText(request.getOldText());
        review.setText(request.getNewText());
        reviewRepository.save(review);
    }


    public void deleteLastReview() {
        reviewRepository.deleteTopByOrderByCreatedAtDesc();
    }
}