package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "OPINJECTION")
@NoArgsConstructor
@AllArgsConstructor
public class OPInjection {

    @Id
    @GeneratedValue
    @Column(name = "OPINJECTIONID")
    private int OPInjectionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "OPID", referencedColumnName = "OPID")
    //@JsonBackReference("outpatient-admission")
    private Outpatient OPId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "NURSEID", referencedColumnName = "NURSEID")
    //@JsonBackReference("nurse-admission")
    private Nurse NurseId;
}
