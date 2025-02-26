package com.patient.patient.Service;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.OPLabTestReport;
import com.patient.patient.Repository.OPLabTestReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OPLabTestReportService {

    @Autowired
    private OPLabTestReportRepo opLabTestReportRepo;

    public OPLabTestReport saveOPLabTestReportDetails(OPLabTestReport opLabTestReport){
        return opLabTestReportRepo.save(opLabTestReport);
    }
    public List<OPLabTestReport> getOPLabTestReportDetails(){
        return opLabTestReportRepo.findAll();
    }
}
