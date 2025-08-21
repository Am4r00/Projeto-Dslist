package com.Dslist.Dslist.repository;

import com.Dslist.Dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
