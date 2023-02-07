package cz.cvut.vk.controller;

import cz.cvut.vk.model.UserDto;
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

    @GetMapping("/logout/{username}/{passwd}")
    public String logout(@PathVariable String username,@PathVariable String passwd){
        boolean canLogout = userService.login(username, passwd);
        if (!canLogout) return "spatne heslo";
        userService.logout(username, passwd);
        return "uzivatel odhlasen";
    }

    @GetMapping("/play/{username}/{passwd}")
    public String play(@PathVariable String username,@PathVariable String passwd){
        boolean canPlay = userService.login(username, passwd);
        if (!canPlay) return "spatne heslo";
        return userService.play(username, passwd);
    }

    @PostMapping("/{username}/{passwd}/command/{command}")
    public String command(@PathVariable String username,@PathVariable String passwd, @PathVariable String command){
        return userService.executeCommand(username, passwd, command, null);
    }

    @PostMapping("/{username}/{passwd}/command/{command}/{object}")
    public String command(@PathVariable String username,@PathVariable String passwd, @PathVariable String command, @PathVariable String object){
        return userService.executeCommand(username, passwd, command, object);
    }

}
