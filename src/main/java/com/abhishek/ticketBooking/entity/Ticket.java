package com.abhishek.ticketBooking.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Schedule schedule;

    @Column(columnDefinition = "DATETIME")
    private Timestamp bookingTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Seat seat;
}
