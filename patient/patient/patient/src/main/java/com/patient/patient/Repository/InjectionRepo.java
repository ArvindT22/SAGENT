package com.patient.patient.Repository;

import com.patient.patient.Entity.Injection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InjectionRepo extends JpaRepository<Injection, Integer> {
}
