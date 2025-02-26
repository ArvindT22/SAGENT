package com.patient.patient.Controller;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.PatientReadings;
import com.patient.patient.Service.PatientReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PatientReadingsController {

    @Autowired
    private PatientReadingsService patientReadingsService;

    @PostMapping("/addPatientReadingsDetails")
    public PatientReadings postPatientReadingsDetails(@RequestBody PatientReadings patientReadings){
        return patientReadingsService.savePatientReadingsDetails(patientReadings);
    }

    @GetMapping("/getPatientReadingsUsingPatientId/{patientId}")
        public List<PatientReadings> fetchPatientReadingsUsingPatientId(@PathVariable int patientId){
            return patientReadingsService.fetchPatientReadingsUsingPatientId(patientId);
    }


    @GetMapping("/getPatientReadingsDetails")
    public List<PatientReadings> getPatientReadingsDetails(){
        return patientReadingsService.getPatientReadingsDetails();
    }
}
