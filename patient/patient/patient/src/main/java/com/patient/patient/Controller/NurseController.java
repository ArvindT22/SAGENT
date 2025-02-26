package com.patient.patient.Controller;

import com.patient.patient.Entity.Nurse;
import com.patient.patient.Service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PostMapping("/addNurseDetails")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Nurse nurse = nurseService.authenticateNurse(username, password);
        if (nurse != null) {
            return ResponseEntity.ok(nurse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/getNurseUsingUsername/{username}")
    public Nurse fetchNurseUsingUsername(@PathVariable String username){
        return nurseService.fetchNurseUsingUsername(username);
    }

    @GetMapping("/getNurseDetails")
    public List<Nurse> getNurseDetails() {
        return nurseService.getNurseDetails();
    }

}
