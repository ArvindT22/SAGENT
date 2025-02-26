package com.patient.patient.Repository;

import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.DoctorReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    Doctor findByUsername(String username);

    @Query(value = "SELECT d FROM Doctor d where username=:username")
    public Doctor fetchDoctorUsingUsername(@Param("username") String username);

}
