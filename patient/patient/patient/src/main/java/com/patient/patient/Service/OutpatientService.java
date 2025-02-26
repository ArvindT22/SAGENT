package com.patient.patient.Service;

import com.patient.patient.Entity.Outpatient;
import com.patient.patient.Repository.OutpatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutpatientService {

    @Autowired
    private OutpatientRepo outpatientRepo;

    public Outpatient saveOutpatientDetails(Outpatient outpatient) {
        return outpatientRepo.save(outpatient);
    }

//    public Outpatient checkPatient(String patientId) {
//        // Use the correct method from OutpatientRepo
//        Outpatient outpatient = outpatientRepo.findByPatient_PatientId(patientId);
//        if (outpatient != null) {
//            return outpatient;
//        }
//        return null;
//    }

    public List<Outpatient> getOutpatientDetails() {
        return outpatientRepo.findAll();
    }
}

