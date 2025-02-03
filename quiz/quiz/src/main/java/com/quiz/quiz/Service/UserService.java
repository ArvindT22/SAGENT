package com.quiz.quiz.Service;


import com.quiz.quiz.Entitiy.User;
import com.quiz.quiz.Repository.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service; 

import java.util.List;


@Service

public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUserDetails(User user){
        return userRepo.save(user);
    }

    public List<User> fetchAllUserDetails(){
        return userRepo.fetchAllUserDetails();
    }

    public User fetchUserUsingUserid(int userid){
        return userRepo.findById(userid).orElse(null);
    }

    public User fetchUserUsingUsername(String Username){
        return userRepo.fetchUserUsingUsername(Username);
    }
//    public User getUserById(int userId) {
//        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//    }
}
