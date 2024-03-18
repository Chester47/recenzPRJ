package com.example.demo.service;

import com.example.demo.controller.rq.CreateReviewRequest;
import com.example.demo.controller.rq.UpdateReviewRequest;
import com.example.demo.entity.Game;
import com.example.demo.entity.Review;
import com.example.demo.exception.GameNotFoundException;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;
    private String[] randomTextByRev = {"ssadasd", "adasd", "asdad", "dasdasdasd", "asdas"};

    public Review createReview(CreateReviewRequest request) {
        Review review = new Review();
        review.setText(request.getText());

        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(()
                        -> new GameNotFoundException("Game not found"));
        review.setGame(game);

        return reviewRepository.save(review);
    }

    public List<Review>createRandomReview(int reviewQuantity) {

        List<Review> createdReview = new ArrayList<>();

        for (int i = 0; i < reviewQuantity; i++) {

            Review review = new Review();
            Random random = new Random();

            List<Game> allGames = gameRepository.findAll();
            Game randGame = allGames.get(random.nextInt(allGames.size()));
            review.setGame(randGame);

            int randomIntInd = random.nextInt(randomTextByRev.length);
            String randomText = randomTextByRev[randomIntInd];
            review.setText(randomText);
            Review savedRev = reviewRepository.save(review);
            createdReview.add(savedRev);
        }
        return createdReview;
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