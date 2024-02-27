package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final String[] possibleTitles = {"Adventure Quest", "Mystery Mansion", "Galactic Odyssey", "Epic Conquest"};


    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game generateRandomGame() {
        // Реализация генерации случайной игры
        Game game = new Game();
        game.setId(UUID.randomUUID());

        // Выбираем случайное название из массива possibleTitles
        Random random = new Random();
        int randomIndex = random.nextInt(possibleTitles.length);
        String randomTitle = possibleTitles[randomIndex];

        game.setTitle(randomTitle);
        return game;
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public List<Game> getGamesByTitle(String title) {
        return gameRepository.findByTitle(title);
    }

    public void deleteGameByTitle(String title) {
        gameRepository.deleteByTitle(title);
    }

    public void clearAllGames() {
        gameRepository.deleteAll();
    }
}




