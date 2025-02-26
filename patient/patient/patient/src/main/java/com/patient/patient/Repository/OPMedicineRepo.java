package com.patient.patient.Repository;

import com.patient.patient.Entity.OPMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OPMedicineRepo extends JpaRepository<OPMedicine, Integer> {
    @Query("SELECT o FROM OPMedicine o where o.PatientId.PatientId = :patientId")
    public List<OPMedicine> fetchOPMedicineUsingPatientId(@Param("patientId") int patientId);
}
