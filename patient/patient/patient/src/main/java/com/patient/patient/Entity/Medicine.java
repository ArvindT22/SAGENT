package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "MEDICINE")
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue
    @Column(name = "MEDICINEID")
    private int MedicineId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DOCTORID", referencedColumnName = "DOCTORID")
    //@JsonBackReference("doctor-admission")
    private Doctor DoctorId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADMISSIONID", referencedColumnName = "ADMISSIONID")
    //@JsonBackReference("admission-admission")
    private Admission AdmissionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
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

    @OneToMany(mappedBy = "MedicineId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("injection-admission")
    @JsonIgnore
    private List<Injection> injection;
}
