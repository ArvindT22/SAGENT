package com.patient.patient.Service;

import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Medicine;
import com.patient.patient.Repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    public Medicine saveMedicineDetails(Medicine medicine){
        return medicineRepo.save(medicine);
    }

    public List<Medicine> fetchMedicineUsingPatientId(int PatientId){
        return medicineRepo.fetchMedicineUsingPatientId(PatientId);
    }

    public List<Medicine> getMedicineDetails(){
        return medicineRepo.findAll();
    }
}
