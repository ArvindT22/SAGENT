package com.patient.patient.Controller;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctorDetails")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Doctor doctor = doctorService.authenticateDoctor(username, password);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/getDoctorUsingUsername/{username}")
    public Doctor fetchDoctorUsingUsername(@PathVariable String username){
        return doctorService.fetchDoctorUsingUsername(username);
    }

    @GetMapping("/getDoctorDetails")
    public List<Doctor> getDoctorDetails(){
        return doctorService.getDoctorDetails();
    }
}
