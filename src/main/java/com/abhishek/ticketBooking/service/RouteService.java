package com.abhishek.ticketBooking.service;


import com.abhishek.ticketBooking.entity.Route;
import com.abhishek.ticketBooking.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository repository;

    public List<Route> getRouteBySourceAndDestination(String source, String destination) {
        return repository.findBySourceAndDestination(source, destination);
    }

    public List<String> getSourceList() {
        return repository.findAllSource();
    }

    public List<String> getDestinationList() {
        return repository.findAllDestination();
    }

    public Route createRoute(String source, String destination, double distance) {
        Route route = new Route();
        route.setDestination(destination);
        route.setDistance(distance);
        route.setSource(source);
        repository.save(route);
        return route;
    }
}
