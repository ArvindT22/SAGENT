package com.quiz.quiz.Entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "USERDB")
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @Column(name = "USERID")
    @GeneratedValue
    private int UserId;

    @Column(name = "USERNAME")
    private String Username;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "AGE")
    private int Age;

    @Column(name = "EMAIL")
    private String Email;

    @Column(name = "ROLL")
    private String Roll;

    @OneToMany(mappedBy = "userid", cascade = CascadeType.ALL)
    private List<Leaderboard> leaderboards;

}
