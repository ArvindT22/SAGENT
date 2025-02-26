package com.patient.patient.Service;


import com.patient.patient.Entity.LabTestReport;
import com.patient.patient.Entity.Login;
import com.patient.patient.Repository.LabTestReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestReportService {

    @Autowired
    private LabTestReportRepo labTestReportRepo;

    public LabTestReport saveLabTestReportDetails(LabTestReport labTestReport){
        return labTestReportRepo.save(labTestReport);
    }
    public List<LabTestReport> getLabTestReportDetails(){
        return labTestReportRepo.findAll();
    }
}
