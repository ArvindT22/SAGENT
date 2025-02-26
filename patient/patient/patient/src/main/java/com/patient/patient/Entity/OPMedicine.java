package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "OPMEDICINE")
@NoArgsConstructor
@AllArgsConstructor
public class OPMedicine {

    @Id
    @GeneratedValue
    @Column(name = "OPMEDICINEID")
    private int OPMedicineId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "OPID", referencedColumnName = "OPID")
    //@JsonBackReference("outpatient-admission")
    private Outpatient OPId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    //@JsonBackReference("outpatient-admission")
    private Patient PatientId;

    @Column(name = "MNAME")
    private String MName;

    @Column(name = "DOSAGE")
    private int Dosage;

    @Column(name = "DURATION")
    private int Duration;

    @Column(name = "FREQUENCY")
    private int Frequency;

    @Temporal(TemporalType.DATE)
    @Column(name = "PRESCRIBEDDATE")
    private Date PrescribedDate;

}
