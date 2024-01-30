package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.service.GameService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("/games")
public class GameController {

    
    private final GameService gameService;

    @PostMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping("/generate")
    public Game generateAndSaveRandomGame() {
        Game randomGame = gameService.generateRandomGame();
        gameService.saveGame(randomGame);
        return randomGame;
    }
}
