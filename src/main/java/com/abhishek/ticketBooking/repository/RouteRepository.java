package com.abhishek.ticketBooking.repository;

import com.abhishek.ticketBooking.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {

    List<Route> findBySourceAndDestination(String source, String destination);

    @Query("SELECT DISTINCT r.source FROM Route r")
    List<String> findAllSource();

    @Query("SELECT DISTINCT r.destination FROM Route r")
    List<String> findAllDestination();
}
