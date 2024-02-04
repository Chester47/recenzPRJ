package com.example.demo.repository;

import com.example.demo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Transactional
@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {
    List<Game> findByTitle(String title);
    @Modifying
    void deleteByTitle(String title);
}
