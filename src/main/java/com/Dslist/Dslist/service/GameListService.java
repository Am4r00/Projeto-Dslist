package com.Dslist.Dslist.service;

import com.Dslist.Dslist.dto.GameListDTO;
import com.Dslist.Dslist.entities.GameList;
import com.Dslist.Dslist.repository.GameListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDTO> findAllGameList(){
        List<GameList> gameLists = gameListRepository.findAll();
        return  gameLists.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public GameListDTO findById(long id) {
        GameList result = gameListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found !"));
        return new GameListDTO(result);
    }
}
