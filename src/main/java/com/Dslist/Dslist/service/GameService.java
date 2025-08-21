package com.Dslist.Dslist.service;

import com.Dslist.Dslist.dto.GameDTO;
import com.Dslist.Dslist.dto.GameMinDTO;
import com.Dslist.Dslist.entities.Game;
import com.Dslist.Dslist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional
    public GameDTO findById(long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found !"));
        return new GameDTO(result);
    }
}
