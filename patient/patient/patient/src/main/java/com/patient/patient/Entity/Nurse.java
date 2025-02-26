package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "NURSE")
@NoArgsConstructor
@AllArgsConstructor
public class Nurse {

    @Id
    @Column(name = "NURSEID")
    @GeneratedValue
    private int NurseId;

    @Column(name = "NNAME")
    private String NName;

    @Column(name = "NPHNO")
    private long NPhno;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "NurseId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("nurse-admission")
    @JsonIgnore
    private List<OPInjection> opInjection;

    @OneToMany(mappedBy = "NurseId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("nurse-admission")
    @JsonIgnore
    private List<Admission> admission;

    @OneToMany(mappedBy = "NurseId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("nurse-admission")
    @JsonIgnore
    private List<PatientReadings> patientReadings;

    @OneToMany(mappedBy = "NurseId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("nurse-admission")
    @JsonIgnore
    private List<Injection> injection;
}
