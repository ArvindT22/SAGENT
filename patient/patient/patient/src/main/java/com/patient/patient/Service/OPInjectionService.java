package com.patient.patient.Service;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.OPInjection;
import com.patient.patient.Repository.OPInjectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OPInjectionService {

    @Autowired
    private OPInjectionRepo opInjectionRepo;

    public OPInjection saveOPInjectionDetails(OPInjection opInjection){
        return opInjectionRepo.save(opInjection);
    }
    public List<OPInjection> getOPInjectionDetails(){
        return opInjectionRepo.findAll();
    }
}
