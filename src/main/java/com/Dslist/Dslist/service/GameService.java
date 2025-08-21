package com.Dslist.Dslist.service;

import com.Dslist.Dslist.dto.GameMinDTO;
import com.Dslist.Dslist.entities.Game;
import com.Dslist.Dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> gameList = gameRepository.findAll();
        return  gameList.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
