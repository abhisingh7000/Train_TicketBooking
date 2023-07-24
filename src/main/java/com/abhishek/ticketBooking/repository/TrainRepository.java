package com.abhishek.ticketBooking.repository;

import com.abhishek.ticketBooking.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {
}
