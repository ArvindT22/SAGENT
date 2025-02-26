package com.patient.patient.Controller;


import com.patient.patient.Entity.Injection;
import com.patient.patient.Entity.Login;
import com.patient.patient.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/addLoginDetails")
    public Login postLoginDetails(@RequestBody Login login){
        return loginService.saveLoginDetails(login);
    }
    @GetMapping("/getLoginDetails")
    public List<Login> getLoginDetails(){
        return loginService.getLoginDetails();
    }
}
