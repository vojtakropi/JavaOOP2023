package cz.cvut.vk.service;

import cz.cvut.vk.model.GameRecord;
import cz.cvut.vk.model.UserRecord;
import cz.cvut.vk.repository.GameRecordRepository;
import cz.cvut.vk.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
public class GameRecordService {

    private final GameRecordRepository gameRecordRepository;

    private final UserRepository userRepository;

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

    @Transactional
    public String topTen(){
        LinkedList<GameRecord> allentries = gameRecordRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<GameRecord, Long> topTen = new HashMap<>();
        List<Long> sorted = new ArrayList<>();
        for (GameRecord allentry : allentries) {
           if(topTen.size()<10){
               topTen.put(allentry, allentry.getTime());
               sorted.add(allentry.getTime());
           }else{
               Collections.sort(sorted);
               for (Long num : sorted) {
                   for (Map.Entry<GameRecord, Long> entry : topTen.entrySet()) {
                       if (entry.getValue().equals(num)) {
                           topTen.put(entry.getKey(), num);
                       }
                   }
               }
               if ((topTen.entrySet().stream().reduce((one, two) -> two).get().getValue()) > allentry.getTime()){
                   topTen.remove(topTen.entrySet().stream().reduce((one, two) -> two).get().getKey());
                   topTen.put(allentry, allentry.getTime());
               }
           }
        }
        stringBuilder.append("top 10 \n");
        for (Map.Entry<GameRecord, Long> entry : topTen.entrySet()) {
            stringBuilder.append("hrac: ").append(entry.getKey().getUser().getUsername()).append(", skore: ").append(entry.getValue()).append("\n");
        }
        return stringBuilder + "";
    }
}
