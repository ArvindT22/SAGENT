package com.patient.patient.Repository;

import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NurseRepo extends JpaRepository<Nurse, Integer> {
    Nurse findByUsername(String username);

    @Query("SELECT n FROM Nurse n where username =:username")
    public Nurse fetchNurseUsingUsername(@Param("username") String username);
}
