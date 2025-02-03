package com.quiz.quiz.Service;

import com.quiz.quiz.Entitiy.Leaderboard;
import com.quiz.quiz.Repository.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepo leaderboardRepo;

    public Leaderboard saveLeaderboard(Leaderboard leaderboard){
        return leaderboardRepo.save(leaderboard);
    }
}
