package com.patient.patient.Repository;

import com.patient.patient.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
    Patient findByUsername(String username);

    @Query(value = "SELECT p FROM Patient p where p.DoctorId.DoctorId =:doctorId")
    public List<Patient> fetchPatientUsingDoctorId(@Param("doctorId") int doctorId);

    @Query(value = "SELECT p FROM Patient p where username=:username")
    public Patient fetchPatientUsingUsername(@Param("username") String username);

//    @Query(value = "SELECT p FROM Patient p JOIN p.Admission a WHERE a.NurseId = :nurseId")
//    public List<Patient> fetchPatientUsingNurse(@Param("nurseId") int nurseId);

}
