package com.abhishek.ticketBooking.repository;

import com.abhishek.ticketBooking.entity.Route;
import com.abhishek.ticketBooking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findByRouteAndTravelDate(Route route, LocalDate travelDate);
}
