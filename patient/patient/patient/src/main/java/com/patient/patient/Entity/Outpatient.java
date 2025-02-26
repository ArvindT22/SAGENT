package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "OUTPATIENT")
@NoArgsConstructor
@AllArgsConstructor
public class Outpatient {

    @Id
    @Column(name = "OPID")
    @GeneratedValue
    private int OPId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    private Patient PatientId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DOCTORID", referencedColumnName = "DOCTORID")
    //@JsonBackReference("doctor-admission")
    private Doctor DoctorId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "REPORTID", referencedColumnName = "REPORTID")
    //@JsonBackReference("doctorreport-admission")
    private DoctorReport ReportID;

    @Temporal(TemporalType.DATE)
    @Column(name = "OPDATE")
    private Date OPDate;

    @OneToMany(mappedBy = "OPId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("opMedicine-admission")
    @JsonIgnore
    private List<OPMedicine> opMedicine;

    @OneToMany(mappedBy = "OPId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("opInjection-admission")
    @JsonIgnore
    private List<OPInjection> opInjection;

    @OneToMany(mappedBy = "OPId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("opLabTestReport-admission")
    @JsonIgnore
    private List<OPLabTestReport> opLabTestReport;

}
