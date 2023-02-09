package cz.cvut.vk.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "scoreboard")
@Getter
@Setter
public class GameRecord {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserRecord user;
    @Column(name = "time")
    private Long time;

    @Column(name = "game")
    private String game;
    @Column(name = "state")
    private String state;

}
