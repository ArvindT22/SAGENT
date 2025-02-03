package com.quiz.quiz.Controller;


import com.quiz.quiz.Entitiy.Leaderboard;
import com.quiz.quiz.Entitiy.User;
import com.quiz.quiz.Service.LeaderboardService;
import com.quiz.quiz.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

//    @Autowired
//    private UserService userService;

    @PostMapping("/addLeaderboard")
    public Leaderboard postLeaderboard(@RequestBody Leaderboard leaderboard){
        return leaderboardService.saveLeaderboard(leaderboard);
    }

//    @PostMapping("/addLeaderboard")
//    public Leaderboard postLeaderboard(@RequestBody Leaderboard leaderboard) {
//        // Fetch the User entity based on UserId from the request
//        User user = userService.getUserById(leaderboard.getUserid().getUserId());
//
//        // Set the fetched user in the leaderboard entity
//        leaderboard.setUserid(user); // Set the user in the leaderboard
//
//        // Save the leaderboard entry and return it
//        return leaderboardService.saveLeaderboard(leaderboard);
//
//    }
}