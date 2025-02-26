package com.patient.patient.Controller;


import com.patient.patient.Entity.DoctorDetails;
import com.patient.patient.Entity.Login;
import com.patient.patient.Service.DoctorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DoctorDetailsController {

    @Autowired
    private DoctorDetailsService doctorDetailsService;

    @PostMapping("/addDoctorDetailsDetails")
    public DoctorDetails postDoctorDetailsDetails(@RequestBody DoctorDetails doctorDetails){
        return doctorDetailsService.saveDoctorDetailsDetails(doctorDetails);
    }
    @GetMapping("/getDoctorDetailsDetails")
    public List<DoctorDetails> getDoctorDetailsDetailsDetails(){
        return doctorDetailsService.getDoctorDetailsDetails();
    }

}
