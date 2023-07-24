package com.abhishek.ticketBooking.repository;

import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    Driver findByTrain(Train train);
}
