package cz.cvut.vk.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "guser")
public class UserRecord {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String passwd;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameRecord> games = new ArrayList<>();

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

    public List<GameRecord> getGames() {
        return games;
    }

    public void setGames(List<GameRecord> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRecord that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPasswd(), that.getPasswd());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPasswd());
    }
}
