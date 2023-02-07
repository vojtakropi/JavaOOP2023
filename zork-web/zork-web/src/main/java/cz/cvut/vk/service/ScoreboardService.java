package cz.cvut.vk.service;

import cz.cvut.vk.model.ScoreboardRecord;
import cz.cvut.vk.repository.ScoreboardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ScoreboardService {

    private final ScoreboardRepository scoreboardRepository;

    public ScoreboardService(ScoreboardRepository scoreboardRepository) {
        this.scoreboardRepository = scoreboardRepository;
    }

    @Transactional
    public String myGames(String username){
        LinkedList<ScoreboardRecord> scoreboardRecords = scoreboardRepository.findByName(username);
        StringBuilder stringBuilder = new StringBuilder();
        for (ScoreboardRecord score: scoreboardRecords) {
            stringBuilder.append("cas: ").append(score.getTime()).append("stav: ").append(score.getState()).append("\n");
        }
        return "tvoje hry: \n" + stringBuilder;
    }

    @Transactional
    public String topTen(){
        LinkedList<ScoreboardRecord> allentries = scoreboardRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (ScoreboardRecord allentry : allentries) {
            stringBuilder.append("Jmeno: ").append(allentry.getName()).append("  cas: ").append(allentry.getTime()).append("\n");
        }
        return stringBuilder + "";
    }
}
