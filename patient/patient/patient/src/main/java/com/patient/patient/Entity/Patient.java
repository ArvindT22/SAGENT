package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "PATIENT")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(name = "PATIENTID")
    @GeneratedValue
    private int PatientId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DOCTORID", referencedColumnName = "DOCTORID")
    private Doctor DoctorId;

    @Column(name = "PNAME")
    private String PName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    private Date DOB;

    @Column(name = "ADDRESS")
    private String Address;

    @Column(name = "GENDER")
    private String Gender;

    @Column(name = "PMOBILE")
    private long PMobile;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ISADMITTED", columnDefinition = "TINYINT(1)", nullable = false)
    private boolean isAdmitted;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("patientReport-admission")
    @JsonIgnore
    private List<DoctorReport> doctorReport;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("patientReport-admission")
    @JsonIgnore
    private List<Medicine> medicine;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("outpatient-admission")
    @JsonIgnore
    private List<Outpatient> outpatient;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<Admission> admission;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<OPMedicine> opMedicine;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<Injection> injection;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<LabTestReport> labTestReport;

    @OneToMany(mappedBy = "PatientId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<PatientReadings> patientReadings;
}
