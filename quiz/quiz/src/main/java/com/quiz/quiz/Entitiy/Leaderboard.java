package com.quiz.quiz.Entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "LEADERBOARD")
@NoArgsConstructor
@AllArgsConstructor
public class Leaderboard {

    @Id
    @Column(name = "LEADERID")
    @GeneratedValue
    private int LeaderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERID" , referencedColumnName = "USERID")
    private User userid;

    @Column(name = "USERRANK")
    private int UserRank;

    @Column(name = "SCORE")
    private int Score;
}
