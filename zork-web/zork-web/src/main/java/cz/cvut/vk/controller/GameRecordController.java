package cz.cvut.vk.controller;

import cz.cvut.vk.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/")
public class GameRecordController {


    @Autowired
    private final GameRecordService gameRecordService;


    public GameRecordController(GameRecordService gameRecordService) {
        this.gameRecordService = gameRecordService;
    }


    /*@GetMapping("/leaders")
    public String getLeaders(){
        return gameRecordService.topTen();
    }*/

    @GetMapping("/games/{username}")
    public String myGames(@PathVariable String username){
        boolean canPlay = gameRecordService.status(username);
        if (!canPlay) return "You played no games yet";
        return gameRecordService.myGames(username);
    }

}
