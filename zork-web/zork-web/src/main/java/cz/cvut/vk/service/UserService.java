package cz.cvut.vk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import cz.cvut.vk.game.Game;
import cz.cvut.vk.game.GameImpl;
import cz.cvut.vk.model.GameRecord;
import cz.cvut.vk.model.UserRecord;
import cz.cvut.vk.repository.GameRecordRepository;
import cz.cvut.vk.repository.UserRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserService {

    private HashMap<String, Game> onlineusers = new HashMap<>();

    private final UserRepository userRepository;

    private final GameRecordRepository gameRecordRepository;

    public UserService(UserRepository userRepository, GameRecordRepository gameRecordRepository) {
        this.userRepository = userRepository;
        this.gameRecordRepository = gameRecordRepository;
    }

    private UserRecord findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public String play(String username, String passwd){
        UserRecord userRecord = verifyUser(username, passwd);
        if (userRecord == null || !Objects.equals(userRecord.getPasswd(), passwd)) return "spate prihlasovaci udaje";
        Game game = new GameImpl();
        onlineusers.put(userRecord.getUsername(), game);
        return game.welcomeMessage();
    }

    private UserRecord verifyUser(String username, String passwd){
        UserRecord userRecord = findByUsername(username);
        if (userRecord == null || !userRecord.getPasswd().equals(passwd))return null;
        return userRecord;
    }

    @Transactional
    private void saveScore(UserRecord userRecord, Long score, String state, Game game) throws JsonProcessingException {
        GameRecord gameRecord = new GameRecord();
        ObjectMapper objectMapper = new ObjectMapper();
        gameRecord.setUser(userRecord);
        gameRecord.setState(state);
        gameRecord.setTime(0L);
        gameRecord.setTime(score);
        boolean u = objectMapper.canSerialize(game.getClass());
        String t = objectMapper.writeValueAsString(game);
        gameRecord.setGame(t);
        userRecord.getGames().add(gameRecord);
        userRepository.save(userRecord);
    }

    private GameRecord getGame(String username, String paswd, Long gameid){
        Optional<GameRecord> gameRecord = gameRecordRepository.findById(gameid);
        if (gameRecord.isEmpty()) return null;
        if (Objects.equals(gameRecord.get().getUser().getUsername(), username) && Objects.equals(gameRecord.get().getUser().getPasswd(), paswd)){
            return gameRecord.get();
        }
        return null;
    }
    public String executeCommand(String username, String passwd, String command, String object) throws JsonProcessingException {
      UserRecord userRecord = verifyUser(username, passwd);
      if (userRecord == null) return "spate prihlasovaci udaje";
      if(onlineusers.get(userRecord.getUsername()) == null) return "nemas zaplou hru";
      String message = onlineusers.get(userRecord.getUsername()).processTextCommand(command + " " + object);
      if (onlineusers.get(userRecord.getUsername()).isFinished()){
          String state;
          if(onlineusers.get(userRecord.getUsername()).ended()){
               state = "Dohrana";
          }else state = "Nedohrana";
          Long score = onlineusers.get(userRecord.getUsername()).getDiference();
          saveScore(userRecord, score, state, onlineusers.get(userRecord.getUsername()));
          onlineusers.remove(userRecord.getUsername());
          return message;
      }
      return message;
    }

    public String logout(String username, String passwd) throws JsonProcessingException {
        UserRecord userRecord = verifyUser(username, passwd);
        if (userRecord == null) return "spatne prihlasovaci udaje";
        saveScore(userRecord, onlineusers.get(username).getDiference(), "Nedohrana", onlineusers.get(userRecord.getUsername()));
        onlineusers.remove(username);
        return "uzivatel odhlasen, hra ulozena";
    }

    public String changeGame(String username, String passwd, Long gameid) throws JsonProcessingException {
        UserRecord userRecord = verifyUser(username, passwd);
        if (userRecord == null) return "spate prihlasovaci udaje";
        Optional<GameRecord> gameRecord = gameRecordRepository.findById(gameid);
        if (gameRecord.isEmpty()) return "not a valid game id";
        ObjectMapper objectMapper = new ObjectMapper();
        Game game = objectMapper.readValue(gameRecord.get().getGame(), Game.class);
        onlineusers.put(userRecord.getUsername(), game);
        return "game changed";
    }

    public boolean login(String username, String passwd){
        UserRecord userRecord = findByUsername(username);
        return userRecord.getPasswd().equals(passwd);
    }
    @Transactional
    public String resgister(String username, String passwd) {
        UserRecord userRecord = new UserRecord();
        UserRecord userRecord2 = findByUsername(username);
        if (userRecord2!=null) return "uzivatel s timto prihlasovacim jmenem uz existuje";
        userRecord.setUsername(username);
        userRecord.setPasswd(passwd);
        userRepository.save(userRecord);
        return "uzivatel registrovan";
    }
}
