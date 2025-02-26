package com.patient.patient.Controller;


import com.patient.patient.Entity.LabTestReport;
import com.patient.patient.Entity.Login;
import com.patient.patient.Service.LabTestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LabTestReportController {

    @Autowired
    private LabTestReportService labTestReportService;

    @PostMapping("/addLabTestReportDetails")
    public LabTestReport postLabTestReportDeatils(@RequestBody LabTestReport labTestReport){
        return labTestReportService.saveLabTestReportDetails(labTestReport);
    }
    @GetMapping("/getLabTestReportDetails")
    public List<LabTestReport> getLabTestReportDetails(){
        return labTestReportService.getLabTestReportDetails();
    }
}
