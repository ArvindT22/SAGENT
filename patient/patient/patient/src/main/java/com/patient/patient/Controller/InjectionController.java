package com.patient.patient.Controller;


import com.patient.patient.Entity.Injection;
import com.patient.patient.Entity.Login;
import com.patient.patient.Service.InjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InjectionController {

    @Autowired
    private InjectionService injectionService;

    @PostMapping("/addInjectionDetails")
    public Injection postInjectionDetails(@RequestBody Injection injection){
        return injectionService.saveInjectionDetails(injection);
    }

    @GetMapping("/getInjectionDetails")
    public List<Injection> getInjectionDetails(){
        return injectionService.getInjectionDetails();
    }
}


