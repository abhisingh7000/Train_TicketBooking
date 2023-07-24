package com.abhishek.ticketBooking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Train {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String owner;
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer noOfSeats;
    private String licensePlate;
}
