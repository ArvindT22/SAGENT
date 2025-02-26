package com.patient.patient.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "ROOM")
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "ROOMID")
    private int RoomId;

    @Column(name = "ROOMTYPE")
    @JsonProperty("roomType")
    private String RoomType;

    @Column(name = "ISOCCUPIED", columnDefinition = "TINYINT(1)", nullable = false)
    @JsonProperty("occupied")
    private boolean isOccupied;

    @OneToMany(mappedBy = "RoomId", cascade = CascadeType.MERGE)
    //@JsonManagedReference("admission-admission")
    @JsonIgnore
    private List<Admission> admission;
}
