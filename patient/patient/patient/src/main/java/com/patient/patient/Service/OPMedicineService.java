package com.patient.patient.Service;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.OPMedicine;
import com.patient.patient.Repository.OPMedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OPMedicineService {

    @Autowired
    private OPMedicineRepo opMedicineRepo;

    public List<OPMedicine> fetchOPMedicineUsingPatientId(int PatientId){
        return opMedicineRepo.fetchOPMedicineUsingPatientId(PatientId);
    }

    public OPMedicine saveOPMedicineDetails(OPMedicine opMedicine){
        return opMedicineRepo.save(opMedicine);
    }

    public List<OPMedicine> getOPMedicineDetails(){
        return opMedicineRepo.findAll();
    }
}
