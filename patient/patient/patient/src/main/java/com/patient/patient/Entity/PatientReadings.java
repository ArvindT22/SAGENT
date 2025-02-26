package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "PATIENTREADINGS")
@NoArgsConstructor
@AllArgsConstructor
public class PatientReadings {

    @Id
    @GeneratedValue
    @Column(name = "READINGID")
    private int ReadingId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADMISSIONID", referencedColumnName = "ADMISSIONID")
    //@JsonBackReference("admission-admission")
    private Admission AdmissionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "NURSEID", referencedColumnName = "NURSEID")
    //@JsonBackReference("nurse-admission")
    private Nurse NurseId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    //@JsonBackReference("nurse-admission")
    private Patient PatientId;

    @Temporal(TemporalType.DATE)
    @Column(name = "READINGDATE")
    private Date ReadingDate;

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

}
