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
@Table(name = "DOCTORREPORT")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorReport {

    @Id
    @Column(name = "REPORTID")
    @GeneratedValue
    private int ReportID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DOCTORID", referencedColumnName = "DOCTORID")
    //@JsonBackReference("doctorReport-admission")
    private Doctor DoctorId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    //@JsonBackReference("patientReport")
    private Patient PatientId;

    @Column(name = "DIAGNOSIS")
    private String Diagnosis;

    @Column(name = "TREATMENTPLAN")
    private String TreatmentPlan;

    @Column(name = "HEARTRATE")
    private int Heartrate;

    @Column(name = "BP")
    private int BP;

    @Column(name = "TEMPERATURE")
    private int Temperature;

    @Column(name = "OXYGEN")
    private int Oxygen;

    @Column(name = "HEMOGLOBIN")
    private int Hemoglobin;

    @OneToMany(mappedBy = "ReportID", cascade = CascadeType.MERGE)
    //@JsonManagedReference("outpatient-admission")
    @JsonIgnore
    private List<Outpatient> outpatient;

    @OneToMany(mappedBy = "ReportID", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<Admission> admission;

}
