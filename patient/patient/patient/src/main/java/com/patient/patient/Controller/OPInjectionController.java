package com.patient.patient.Controller;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.OPInjection;
import com.patient.patient.Service.OPInjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OPInjectionController {

    @Autowired
    private OPInjectionService opInjectionService;

    @PostMapping("/addOPInjectionDetails")
    public OPInjection postOPInjectionDetails(@RequestBody OPInjection opInjection){
        return opInjectionService.saveOPInjectionDetails(opInjection);
    }
    @GetMapping("/getOPInjectionDetails")
    public List<OPInjection> getOPInjectionDetails(){
        return opInjectionService.getOPInjectionDetails();
    }
}
