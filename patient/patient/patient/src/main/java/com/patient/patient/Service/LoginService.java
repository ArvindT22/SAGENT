package com.patient.patient.Service;


import com.patient.patient.Entity.Login;
import com.patient.patient.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepo loginRepo;

    public Login saveLoginDetails( Login login) {
        return  loginRepo.save(login);
    }

    public List<Login> getLoginDetails(){
        return loginRepo.findAll();
    }
}
