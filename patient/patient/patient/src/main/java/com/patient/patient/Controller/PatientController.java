package com.patient.patient.Controller;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Patient;
import com.patient.patient.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

//    @PostMapping("/addPatientDetails")
//    public Patient postPatientDetails(@RequestBody Patient patient){
//        return patientService.savePatientDetails(patient);
//    }

    @PostMapping("/addPatientDetails")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Patient patient = patientService.authenticatePatient(username, password);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

//    @GetMapping("/getPatientUsingNurseId")
//    public List<Patient> fetchPatientUsingNurseId(@PathVariable int nurseId){
//        return patientService.fetchPatientUsingNurseId(nurseId);
//    }

    @GetMapping("/getPatientUsingUsername/{username}")
    public Patient fetchPatientUsingUsername(@PathVariable String username){
        return patientService.fetchPatientUsingUsername(username);
    }

    @GetMapping("/getPatient/{doctorId}")
    public List<Patient> fetchPatientUsingDoctorId(@PathVariable int doctorId){
        return patientService.fetchPatientUsingDoctorId(doctorId);
    }

    @GetMapping("/getPatientDetails")
    public List<Patient> getPatientDetails(){
        return patientService.getPatientDetails();
    }
}
