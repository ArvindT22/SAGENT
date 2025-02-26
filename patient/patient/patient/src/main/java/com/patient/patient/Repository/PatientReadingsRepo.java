package com.patient.patient.Repository;

import com.patient.patient.Entity.PatientReadings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientReadingsRepo extends JpaRepository<PatientReadings, Integer> {

    @Query("SELECT p FROM PatientReadings p where p.PatientId.PatientId =:patientId")
    public List<PatientReadings> fetchPatientReadingsUsingPatientId(@Param("patientId") int patientId);

}
