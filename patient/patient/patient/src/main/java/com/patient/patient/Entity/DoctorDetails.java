package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "DOCTORDETAILS")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDetails {

    @Id
    @GeneratedValue
    @Column(name = "DDID")
    private int DDId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADMISSIONID", referencedColumnName = "ADMISSIONID")
    //@JsonBackReference("admission-admission")
    private Admission AdmissionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DOCTORID", referencedColumnName = "DOCTORID")
    //@JsonBackReference("doctor-admission")
    private Doctor DoctorId;
}
