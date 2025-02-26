package com.patient.patient.Service;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor saveDoctorDetails(Doctor doctor){
        return doctorRepo.save(doctor);
    }

    public Doctor authenticateDoctor(String username, String password) {
        Doctor doctor = doctorRepo.findByUsername(username);
        if (doctor != null && doctor.getPassword().equals(password)) {
            return doctor;
        }
        return null;
    }

    public Doctor fetchDoctorUsingUsername(String Username){
        return doctorRepo.fetchDoctorUsingUsername(Username);
    }

    public List<Doctor> getDoctorDetails(){
        return doctorRepo.findAll();
    }
    public Doctor getDoctorById(int doctorid){
        return doctorRepo.findById(doctorid).orElse(null);
    }
}
