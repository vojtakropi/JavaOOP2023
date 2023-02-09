package cz.cvut.vk.service;

import cz.cvut.vk.model.GameRecord;
import cz.cvut.vk.model.UserRecord;
import cz.cvut.vk.repository.GameRecordRepository;
import cz.cvut.vk.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameRecordService {

    private final GameRecordRepository gameRecordRepository;

    private final UserRepository userRepository;

    public GameRecordService(GameRecordRepository gameRecordRepository, UserRepository userRepository) {
        this.gameRecordRepository = gameRecordRepository;
        this.userRepository = userRepository;
    }
    public boolean status(String username){
        UserRecord userRecord = userRepository.findByUsername(username);
        return userRecord!=null;
    }


    @Transactional
    public String myGames(String username){
        UserRecord user = userRepository.findByUsername(username);
        LinkedList<GameRecord> gameRecords = gameRecordRepository.findByUser_id(user.getId());
        StringBuilder stringBuilder = new StringBuilder();
        for (GameRecord score: gameRecords) {
            stringBuilder.append("ID: ").append(score.getId()).append("cas: ").append(score.getTime()).append(" sekund, stav: ").append(score.getState()).append("\n");
        }
        return "tvoje hry: \n" + stringBuilder;
    }

   /* @Transactional
    public String topTen(){
        LinkedList<GameRecord> allentries = gameRecordRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        List<GameRecord> topTen = new ArrayList<>();
        Long highest = -1L;
        HashMap<GameRecord, Long> high = new HashMap<>();
        high.put(null, highest);
        for (GameRecord allentry : allentries) {
           if(topTen.size()<10){
               topTen.add(allentry);
               if(allentry.getTime()>highest){
                   highest = allentry.getTime();
                   high.clear();
                   high.put(allentry,highest);
               }
           }else{
               if ()
           }
        }
        stringBuilder.append("Jmeno: ").append(allentry.getName()).append("  cas: ").append(allentry.getTime()).append("\n");
        return stringBuilder + "";
    }*/
}
