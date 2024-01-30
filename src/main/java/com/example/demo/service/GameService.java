package com.example.demo.service;

import com.example.demo.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.GameRepository;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game generateRandomGame() {
        // Реализация генерации случайной игры
        Game game = new Game();
        game.setId(UUID.randomUUID());
        game.setTitle("Random Game Title");
        return game;
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
