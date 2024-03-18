package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class GameService {

    private final GameRepository gameRepository;
    private final String[] possibleTitles = {"Adventure Quest", "Mystery Mansion", "Galactic Odyssey", "Epic Conquest"};


    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> generateRandomGames(int numberOfGames) {
        List<Game> allGame = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game();

            Random random = new Random();
            int randomIndex = random.nextInt(possibleTitles.length);
            String randomTitle = possibleTitles[randomIndex];

            game.setTitle(randomTitle);
            allGame.add(game);
        }
        gameRepository.saveAll(allGame);

        return allGame;
    }

    public List<Game> searchGameByPartialForTitle(String partial) {

        List<Game> partialGames = new ArrayList<>();
        List<Game> games = gameRepository.findAll();
        for (Game trai : games) {
            if (trai.getTitle().contains(partial)) {
                partialGames.add(trai);
            }
        }
        return partialGames;

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




