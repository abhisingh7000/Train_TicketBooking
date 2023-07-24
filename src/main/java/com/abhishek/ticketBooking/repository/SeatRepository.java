package com.abhishek.ticketBooking.repository;

import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByTrain(Train train);
}