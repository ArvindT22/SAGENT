package com.patient.patient.Repository;

import com.patient.patient.Entity.DoctorReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface DoctorReportRepo extends JpaRepository<DoctorReport, Integer> {

    @Query("SELECT d FROM DoctorReport d where d.PatientId.PatientId = :patientId")
    public List<DoctorReport> fetchDoctorReportUsingPatientId(@Param("patientId") int patientId);
}
