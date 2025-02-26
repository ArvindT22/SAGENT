package com.patient.patient.Controller;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.DoctorReport;
import com.patient.patient.Service.DoctorReportService;
import com.patient.patient.Service.DoctorService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class DoctorReportController {

    @Autowired
    private DoctorReportService doctorReportService;

    @GetMapping("/getDoctorReportUsingPatientId/{patientId}")
    public List<DoctorReport> fetchDoctorReportUsingPatientId(@PathVariable int patientId){
        return doctorReportService.fetchDoctorReportUsingPatientId(patientId);
    }

    @PostMapping("/addDoctorReportDetails")
    public DoctorReport postDoctorReportDetails(@RequestBody DoctorReport doctorReport){
        return doctorReportService.saveDoctorReportDetails(doctorReport);
    }

}
