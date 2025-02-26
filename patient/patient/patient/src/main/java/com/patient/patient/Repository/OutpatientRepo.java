package com.patient.patient.Repository;

import com.patient.patient.Entity.Outpatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutpatientRepo extends JpaRepository<Outpatient, Integer> {
//    Outpatient findByPatient_PatientId(String patientId);
}
