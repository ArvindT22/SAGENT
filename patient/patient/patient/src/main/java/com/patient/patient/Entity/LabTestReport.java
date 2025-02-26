package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "LABTESTREPORT")
@NoArgsConstructor
@AllArgsConstructor
public class LabTestReport {

    @Id
    @GeneratedValue
    @Column(name = "TESTID")
    private int TestId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADMISSIONID", referencedColumnName = "ADMISSIONID")
    //@JsonBackReference("admission-admission")
    private Admission AdmissionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    //@JsonBackReference("admission-admission")
    private Patient PatientId;

    @Column(name = "TESTNAME")
    private String TestName;

    @Temporal(TemporalType.DATE)
    @Column(name = "TESTDATE")
    private Date TestDate;

    @Column(name = "REPORT")
    private String Report;

}
