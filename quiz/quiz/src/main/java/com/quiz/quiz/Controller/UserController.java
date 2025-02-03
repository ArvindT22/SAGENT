package com.quiz.quiz.Controller;


import com.quiz.quiz.Entitiy.User;
import com.quiz.quiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User postUserDetails(@RequestBody User user){
        return userService.saveUserDetails(user);

    }

    @GetMapping("/getAllUserDetails")
    public List<User> fetchAllUserDetailsController(){
        return userService.fetchAllUserDetails();
    }

    @GetMapping("/getUserUsingUserid/{userid}")
    public User fetchUserUsingUseridController(@PathVariable int userid){
        return userService.fetchUserUsingUserid(userid);
    }

    @GetMapping("/getUserUsingUsername/{Username}")
    public User fetchUserUsingUsername(@PathVariable String Username){
        return userService.fetchUserUsingUsername(Username);
    }

}
