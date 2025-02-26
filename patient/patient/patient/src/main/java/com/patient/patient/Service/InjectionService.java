package com.patient.patient.Service;


import com.patient.patient.Entity.Injection;
import com.patient.patient.Entity.Login;
import com.patient.patient.Repository.InjectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjectionService {

    @Autowired
    InjectionRepo injectionRepo;

    public Injection saveInjectionDetails(Injection injection){

        return injectionRepo.save(injection);
    }
    public List<Injection> getInjectionDetails(){
        return injectionRepo.findAll();
    }
}
