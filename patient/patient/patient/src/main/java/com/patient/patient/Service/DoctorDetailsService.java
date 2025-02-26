package com.patient.patient.Service;


import com.patient.patient.Entity.DoctorDetails;
import com.patient.patient.Entity.Login;
import com.patient.patient.Repository.DoctorDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDetailsService {

    @Autowired
    private DoctorDetailsRepo doctorDetailsRepo;

    public DoctorDetails saveDoctorDetailsDetails(DoctorDetails doctorDetails) {
        return doctorDetailsRepo.save(doctorDetails);
    }

    public List<DoctorDetails> getDoctorDetailsDetails() {
        return doctorDetailsRepo.findAll();
    }
}
