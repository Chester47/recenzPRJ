package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.service.GameService;
import jakarta.websocket.server.PathParam;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

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
    public List<Game> generateAndSaveRandomGame() {
        return gameService.generateRandomGames(100);
    }
    @PostMapping("games/searchByParial")
    public List<Game> searchByPartialForTitles(@PathParam("partial")String partial) {
        return gameService.searchGameByPartialForTitle(partial);
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
