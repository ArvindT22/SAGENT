package com.patient.patient.Service;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.PatientReadings;
import com.patient.patient.Repository.PatientReadingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientReadingsService {

    @Autowired
    private PatientReadingsRepo patientReadingsRepo;

    public List<PatientReadings> fetchPatientReadingsUsingPatientId(int PatientId){
        return patientReadingsRepo.fetchPatientReadingsUsingPatientId(PatientId);
    }

    public PatientReadings savePatientReadingsDetails(PatientReadings patientReadings){
        return patientReadingsRepo.save(patientReadings);
    }
    public List<PatientReadings> getPatientReadingsDetails(){
        return patientReadingsRepo.findAll();
    }
}
