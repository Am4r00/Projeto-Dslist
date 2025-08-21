package com.Dslist.Dslist.controller;

import com.Dslist.Dslist.dto.GameListDTO;
import com.Dslist.Dslist.dto.GameMinDTO;
import com.Dslist.Dslist.service.GameListService;
import com.Dslist.Dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAllGameList(){
        return gameListService.findAllGameList();
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findAllGameListId(@PathVariable Long id){
        return gameListService.findById(id);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findAllGameList(@PathVariable Long  listId){
        return gameService.findAllByList(listId);
    }
}
