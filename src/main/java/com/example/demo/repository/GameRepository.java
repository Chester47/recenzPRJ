package com.example.demo.repository;

import com.example.demo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> { }