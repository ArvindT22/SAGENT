package com.patient.patient.Controller;


import com.patient.patient.Entity.Admission;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Patient;
import com.patient.patient.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @GetMapping("/getAdmissionUsingPatientId/{patientId}")
    public List<Admission> fetchAdmissionUsingPatientId(@PathVariable int patientId){
        return admissionService.fetchAdmissionUsingPatientId(patientId);
    }

    @GetMapping("/getNursePatients/{nurseId}")
    public List<Patient> getPatientsByNurseId(@PathVariable int nurseId) {
        return admissionService.getPatientsByNurseId(nurseId);
    }

    @PostMapping("/addAdmissionDetails")
    public Admission postAdmissionDetails(@RequestBody Admission admission){
        return admissionService.saveAdmissionDetails(admission);
    }
    @GetMapping("/getAdmissionDetails")
    public List<Admission> getAdmissionDetails(){
        return admissionService.getAdmissionDetails();
    }
}
