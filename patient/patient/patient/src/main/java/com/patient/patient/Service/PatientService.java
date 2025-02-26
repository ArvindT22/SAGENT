package com.patient.patient.Service;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Patient;
import com.patient.patient.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public Patient savePatientDetails(Patient patient){
        return patientRepo.save(patient);
    }

    public Patient authenticatePatient(String username, String password) {
        Patient patient = patientRepo.findByUsername(username);
        if (patient != null && patient.getPassword().equals(password)) {
            return patient;
        }
        return null;
    }

//    public List<Patient> fetchPatientUsingNurseId(int NurseId){
//        return patientRepo.fetchPatientUsingNurse(NurseId);
//    }

    public Patient fetchPatientUsingUsername(String Username){
        return patientRepo.fetchPatientUsingUsername(Username);
    }

    public List<Patient> fetchPatientUsingDoctorId(int DoctorId){
        return patientRepo.fetchPatientUsingDoctorId(DoctorId);
    }

    public List<Patient> getPatientDetails(){
        return patientRepo.findAll();
    }

    public Patient getPatientById(int patientid){
        return patientRepo.findById(patientid).orElse(null);
    }

}
