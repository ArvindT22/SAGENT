package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "INJECTION")
@NoArgsConstructor
@AllArgsConstructor
public class Injection {

    @Id
    @GeneratedValue
    @Column(name = "IID")
    private int IId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "MEDICINEID", referencedColumnName = "MEDICINEID")
    //@JsonBackReference("medicine-admission")
    private Medicine MedicineId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADMISSIONID", referencedColumnName = "ADMISSIONID")
    //@JsonBackReference("admission-admission")
    private Admission AdmissionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DOCTORID", referencedColumnName = "DOCTORID")
    //@JsonBackReference("doctor-admission")
    private Doctor DoctorId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "NURSEID", referencedColumnName = "NURSEID")
    //@JsonBackReference("nurse-admission")
    private Nurse NurseId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    //@JsonBackReference("nurse-admission")
    private Patient PatientId;

    @Column(name = "DOSAGE")
    private int Dosage;

    @Column(name = "IDATE")
    private Date IDate;

}
