package com.abhishek.ticketBooking.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Driver {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String driversLicense;
    private LocalDate DOB;
    private String Address;
    private LocalDate DOJ;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainId", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Train train;
}
