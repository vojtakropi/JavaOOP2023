package cz.cvut.vk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.cvut.vk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/")
public class UserController {


    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/{username}/{passwd}")
    public String register(@PathVariable String username,@PathVariable String passwd){
        return userService.resgister(username, passwd);
    }


    @GetMapping("/play/{username}/{passwd}")
    public String play(@PathVariable String username,@PathVariable String passwd){
        return userService.play(username, passwd);
    }
    @GetMapping("/logout/{username}/{passwd}")
    public String logout(@PathVariable String username,@PathVariable String passwd) throws JsonProcessingException {
        return userService.logout(username, passwd);
    }

    @PostMapping("/{username}/{passwd}/command/{command}")
    public String command(@PathVariable String username,@PathVariable String passwd, @PathVariable String command) throws JsonProcessingException {
        return userService.executeCommand(username, passwd, command, null);
    }

    @PostMapping("/{username}/{passwd}/command/{command}/{object}")
    public String command(@PathVariable String username,@PathVariable String passwd, @PathVariable String command, @PathVariable String object) throws JsonProcessingException {
        return userService.executeCommand(username, passwd, command, object);
    }

    @PostMapping("/{username}/{passwd}/change/{gameid}")
    public String changeGame(@PathVariable String username,@PathVariable String passwd, @PathVariable Long gameid) throws JsonProcessingException {
        return userService.changeGame(username, passwd, gameid);
    }


}
