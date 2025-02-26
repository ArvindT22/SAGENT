package com.patient.patient.Service;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.DoctorReport;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Patient;
import com.patient.patient.Repository.DoctorRepo;
import com.patient.patient.Repository.DoctorReportRepo;
import com.patient.patient.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorReportService {

    @Autowired
    private DoctorReportRepo doctorReportRepo;

    public List<DoctorReport> fetchDoctorReportUsingPatientId(int PatientId){
        return doctorReportRepo.fetchDoctorReportUsingPatientId(PatientId);
    }

    public DoctorReport saveDoctorReportDetails(DoctorReport doctorReport){
        return doctorReportRepo.save(doctorReport);
    }
}
