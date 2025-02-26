package com.patient.patient.Repository;

import com.patient.patient.Entity.Admission;
import com.patient.patient.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdmissionRepo extends JpaRepository<Admission, Integer> {
    @Query("SELECT a FROM Admission a where a.PatientId.PatientId = :patientId")
    public List<Admission> fetchAdmissionUsingPatientIt(@Param("patientId") int patientId);

    @Query("SELECT DISTINCT a.PatientId FROM Admission a WHERE a.NurseId.NurseId = :nurseId")
    List<Patient> findPatientsByNurseId(@Param("nurseId") int nurseId);
}
