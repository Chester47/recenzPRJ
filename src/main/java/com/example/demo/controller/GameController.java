package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.service.GameService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/v1")
public class GameController {


    private final GameService gameService;

    @PostMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping("/game/generate")
    public Game generateAndSaveRandomGame() {
        Game randomGame = gameService.generateRandomGame();
        gameService.saveGame(randomGame);
        return randomGame;
    }

    @PostMapping("/game/searchByTitle")
    public List<Game> searchGameByTitle(@RequestParam String title) {
        return gameService.getGamesByTitle(title);
    }

    @PostMapping("/game/deleteByTitle")
    public void deleteGameByTitle(@RequestParam String title) {
        gameService.deleteGameByTitle(title);
    }

    @PostMapping("/games/clear")
    public void clearAllGames() {
        gameService.clearAllGames();
    }
}
