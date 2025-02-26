package com.patient.patient.Repository;

import com.patient.patient.Entity.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDetailsRepo extends JpaRepository<DoctorDetails, Integer> {
}
