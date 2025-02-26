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
@Table(name = "ADMISSION")
@NoArgsConstructor
@AllArgsConstructor
public class Admission {

    @Id
    @Column(name = "ADMISSIONID")
    @GeneratedValue
    private int AdmissionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    //@JsonBackReference("patient-admission")
    private Patient PatientId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "NURSEID", referencedColumnName = "NURSEID")
    //@JsonBackReference("nurse-admission")
    private Nurse NurseId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ROOMID", referencedColumnName = "ROOMID")
    //@JsonBackReference("room-admission")
    private Room RoomId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "REPORTID", referencedColumnName = "REPORTID")
    //@JsonBackReference("doctorreport-admission")
    private DoctorReport ReportID;

    @Temporal(TemporalType.DATE)
    @Column(name = "ADMITDATE")
    private Date AdmitDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DISCHARGEDATE")
    private Date DischargeDate;

    @Column(name = "STATUS")
    private String Status;

    @Column(name = "REASON")
    private String Reason;






    @OneToMany(mappedBy = "AdmissionId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("doctordetails-admission")
    @JsonIgnore
    private List<DoctorDetails> doctorDetails ;

    @OneToMany(mappedBy = "AdmissionId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("patientReadings-admission")
    @JsonIgnore
    private List<PatientReadings> patientReadings;

    @OneToMany(mappedBy = "AdmissionId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("medicine-admission")
    @JsonIgnore
    private List<Medicine> medicine;

    @OneToMany(mappedBy = "AdmissionId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("injection-admission")
    @JsonIgnore
    private List<Injection> injection;

    @OneToMany(mappedBy = "AdmissionId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("labTestReport-admission")
    @JsonIgnore
    private List<LabTestReport> labTestReport;
}
