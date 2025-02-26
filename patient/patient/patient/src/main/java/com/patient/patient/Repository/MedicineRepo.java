package com.patient.patient.Repository;

import com.patient.patient.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

    @Query("SELECT m FROM Medicine m where m.PatientId.PatientId =:patientId")
    public List<Medicine> fetchMedicineUsingPatientId(@Param("patientId") int patientId);
}
