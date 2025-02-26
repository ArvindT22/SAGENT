package com.patient.patient.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "LOGIN")
@NoArgsConstructor
@AllArgsConstructor

public class Login {

    @Id
    @Column(name = "USERNAME")
    private String Username;


    @Column(name = "PASSWORD")
    private String Password;

}
