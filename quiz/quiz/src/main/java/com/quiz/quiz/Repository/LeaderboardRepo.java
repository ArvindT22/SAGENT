package com.quiz.quiz.Repository;

import com.quiz.quiz.Entitiy.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardRepo extends JpaRepository<Leaderboard,Integer> {
}
