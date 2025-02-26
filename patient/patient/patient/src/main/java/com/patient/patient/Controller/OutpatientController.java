package com.patient.patient.Controller;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Outpatient;
import com.patient.patient.Entity.Patient;
import com.patient.patient.Service.OutpatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OutpatientController {

    @Autowired
    private OutpatientService outpatientService;

    @PostMapping("/addOutpatientDetails")
    public Outpatient postOutpatientDetails(@RequestBody Outpatient outpatient){
        return outpatientService.saveOutpatientDetails(outpatient);
    }

//    @PostMapping("/checkPatient")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
//        String patientId = credentials.get("patientId");
//
//        Outpatient outpatient = outpatientService.checkPatient(patientId);
//        if (outpatient != null) {
//            return ResponseEntity.ok(outpatient);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }

    @GetMapping("/getOutpatientDetails")
    public List<Outpatient> getOutpatientDetails(){
        return outpatientService.getOutpatientDetails();
    }
}
