package com.quiz.quiz.Repository;

import com.quiz.quiz.Entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface UserRepo extends JpaRepository< User , Integer > {

    @Query(value = "SELECT u FROM User u")
    public List<User> fetchAllUserDetails();

    @Query(value = "SELECT u FROM User u where Username=:Username")
    public User fetchUserUsingUsername(@Param("Username") String Username);
}
