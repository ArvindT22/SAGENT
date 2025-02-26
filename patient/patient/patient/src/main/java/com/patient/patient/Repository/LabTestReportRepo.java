package com.patient.patient.Repository;

import com.patient.patient.Entity.LabTestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabTestReportRepo extends JpaRepository<LabTestReport, Integer> {
}
