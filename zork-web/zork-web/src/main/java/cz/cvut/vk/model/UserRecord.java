package cz.cvut.vk.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "guser")
@Getter
@Setter
@EqualsAndHashCode
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

}
