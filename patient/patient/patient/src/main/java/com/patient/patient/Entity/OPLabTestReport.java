package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "OPLABTESTREPORT")
@NoArgsConstructor
@AllArgsConstructor
public class OPLabTestReport {

    @Id
    @GeneratedValue
    @Column(name = "OPTESTID")
    private int OPTestId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "OPID", referencedColumnName = "OPID")
    //@JsonBackReference("outpatient-admission")
    private Outpatient OPId;

    @Column(name = "TNAME")
    private String TName;

    @Temporal(TemporalType.DATE)
    @Column(name = "TDATE")
    private Date TDate;

    @Column(name = "REPORT")
    private String Report;
}
