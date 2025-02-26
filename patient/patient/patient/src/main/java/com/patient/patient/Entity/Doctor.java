package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "DOCTOR")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @Column(name = "DOCTORID")
    @GeneratedValue
    private int DoctorId;

    @Column(name = "DNAME")
    private String DName;

    @Column(name = "DEPARTMENT")
    private String Department;

    @Column(name = "DMOBILE")
    private long DMobile;

    @Column(name = "SPECIALIZATION")
    private String Specialization;

    @Column(name = "EXPERIENCE")
    private String Experience;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "DoctorId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("patient-admission")
    @JsonIgnore
    private List<Patient> patient;

    @OneToMany(mappedBy = "DoctorId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("doctorreport-admission")
    @JsonIgnore
    private List<DoctorReport> doctorReport;

    @OneToMany(mappedBy = "DoctorId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("doctordetails-admission")
    @JsonIgnore
    private List<DoctorDetails> doctorDetails;

    @OneToMany(mappedBy = "DoctorId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("outpatient-admission")
    @JsonIgnore
    private List<Outpatient> outpatient;

    @OneToMany(mappedBy = "DoctorId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("medicine-admission")
    @JsonIgnore
    private List<Medicine> medicine;

    @OneToMany(mappedBy = "DoctorId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("injection-admission")
    @JsonIgnore
    private List<Injection> injection;
}


