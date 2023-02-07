package cz.cvut.vk.controller;

import cz.cvut.vk.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/")
public class ScoreboardController {


    @Autowired
    private final ScoreboardService scoreboardService;


    public ScoreboardController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }


    @GetMapping("/leaders")
    public String getLeaders(){
        return scoreboardService.topTen();
    }

    @GetMapping("/games/{username}")
    public String myGames(@PathVariable String username){
        return scoreboardService.myGames(username);
    }

}
