package cz.cvut.vk.service;

import cz.cvut.vk.game.Game;
import cz.cvut.vk.game.GameImpl;
import cz.cvut.vk.model.ScoreboardRecord;
import cz.cvut.vk.model.UserDto;
import cz.cvut.vk.model.UserRecord;
import cz.cvut.vk.repository.ScoreboardRepository;
import cz.cvut.vk.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UserService {

    private HashMap<String, Game> onlineusers = new HashMap<>();

    private final UserRepository userRepository;

    private final ScoreboardRepository scoreboardRepository;

    public UserService(UserRepository userRepository, ScoreboardRepository scoreboardRepository) {
        this.userRepository = userRepository;
        this.scoreboardRepository = scoreboardRepository;
    }

    private UserRecord findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public String play(String username, String passwd){
        UserDto userDto = verifyUser(username, passwd);
        if (userDto == null) return "spate prihlasovaci udaje";
        Game game = new GameImpl();
        onlineusers.put(userDto.getUsername(), game);
        return game.welcomeMessage();
    }

    private UserDto verifyUser(String username, String passwd){
        UserRecord userRecord = findByUsername(username);
        if (userRecord == null || !userRecord.getPasswd().equals(passwd))return null;
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRecord, userDto);
        return userDto;
    }

    @Transactional
    private void saveScore(String username, Long score, String state){
        ScoreboardRecord scoreboardRecord = new ScoreboardRecord();
        scoreboardRecord.setName(username);
        scoreboardRecord.setTime(score);
        scoreboardRecord.setState(state);
        scoreboardRepository.save(scoreboardRecord);
    }
    public String executeCommand(String username, String passwd, String command, String object){
      UserDto userDto = verifyUser(username, passwd);
      if (userDto == null) return "spate prihlasovaci udaje";
      if (onlineusers.get(userDto.getUsername())== null)return "nemas rozehranou hru";
      String message = onlineusers.get(userDto.getUsername()).processTextCommand(command + " " + object);
      if (onlineusers.get(userDto.getUsername()).isFinished()){
          String state;
          if(onlineusers.get(userDto.getUsername()).ended()){
               state = "Dohrana";
          }else state = "Nedohrana";
          Long score = onlineusers.get(userDto.getUsername()).getDiference();
          onlineusers.remove(userDto.getUsername());
          saveScore(username, score, state);
          return message;
      }
      return message;
    }

    public void logout(String username, String passwd){
        saveScore(username, onlineusers.get(username).getDiference(), "Nedohrana");
        onlineusers.remove(username);
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
