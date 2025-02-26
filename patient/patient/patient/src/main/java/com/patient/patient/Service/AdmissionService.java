package com.patient.patient.Service;

import com.patient.patient.Entity.Admission;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Patient;
import com.patient.patient.Repository.AdmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepo admissionRepo;

    public List<Admission> fetchAdmissionUsingPatientId(int PatientId){
        return admissionRepo.fetchAdmissionUsingPatientIt(PatientId);
    }

    public List<Patient> getPatientsByNurseId(int NurseId) {
        return admissionRepo.findPatientsByNurseId(NurseId);
    }

    public Admission saveAdmissionDetails(Admission admission){
        return admissionRepo.save(admission);
    }
    public List<Admission> getAdmissionDetails(){
        return admissionRepo.findAll();
    }
}
