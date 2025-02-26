package com.patient.patient.Repository;

import com.patient.patient.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, String> {
}
