package com.abhishek.ticketBooking.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Train train;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Route route;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate travelDate;
}
