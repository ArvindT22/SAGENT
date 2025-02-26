package com.patient.patient.Controller;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Medicine;
import com.patient.patient.Service.MedicineService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/addMedicineDetails")
    public Medicine postMedicineDetails(@RequestBody Medicine medicine){
        return medicineService.saveMedicineDetails(medicine);
    }

    @GetMapping("/getMedicineUsingPatientId/{patientId}")
    public List<Medicine> fetchMedicineUsingPatientId(@PathVariable int patientId){
        return medicineService.fetchMedicineUsingPatientId(patientId);
    }

    @GetMapping("/getMedicineDetails")
    public List<Medicine> getMedicineDetails(){
        return medicineService.getMedicineDetails();
    }

}
