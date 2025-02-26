package com.patient.patient.Controller;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.OPLabTestReport;
import com.patient.patient.Service.OPLabTestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OPLabTestReportController {

    @Autowired
    private OPLabTestReportService opLabTestReportService;

    @PostMapping("/addOPLabTestReportDetails")
    public OPLabTestReport postOPLabTestReportDetails(@RequestBody OPLabTestReport opLabTestReport){
        return opLabTestReportService.saveOPLabTestReportDetails(opLabTestReport);
    }

    @GetMapping("/getOPLabTestReportDetails")
    public List<OPLabTestReport> getOPLabTestReportDetails(){
        return opLabTestReportService.getOPLabTestReportDetails();
    }
}
