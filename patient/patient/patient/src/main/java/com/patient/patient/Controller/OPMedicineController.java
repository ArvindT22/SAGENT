package com.patient.patient.Controller;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.OPMedicine;
import com.patient.patient.Service.OPMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OPMedicineController {

    @Autowired
    private OPMedicineService opMedicineService;

    @PostMapping("/addOPMedicineDetails")
    public OPMedicine postOPMedicineDetails(@RequestBody OPMedicine opMedicine){
        return opMedicineService.saveOPMedicineDetails(opMedicine);
    }

    @GetMapping("/getOPMedicineUsingPatientId/{patientId}")
    public List<OPMedicine> fetchOPMedicineUsingPatientId(@PathVariable int patientId){
        return opMedicineService.fetchOPMedicineUsingPatientId(patientId);
    }

    @GetMapping("/getOPMedicineDetails")
    public List<OPMedicine> getOPMedicineDetails(){
        return opMedicineService.getOPMedicineDetails();
    }
}
