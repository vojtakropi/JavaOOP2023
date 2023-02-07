package cz.cvut.vk.model;

import cz.cvut.vk.game.Game;
import cz.cvut.vk.game.GameImpl;

public class UserDto {

    private Long id;

    private String username;

    private String passwd;

    public UserDto() {
    }

    public UserDto(Long id, String username, String passwd) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
