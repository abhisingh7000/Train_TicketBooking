package com.abhishek.ticketBooking.controller;

import com.abhishek.ticketBooking.entity.Route;
import com.abhishek.ticketBooking.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired()
    private RouteService routeService;

    @GetMapping("/sources")
    public List<String> listSources() {
        return routeService.getSourceList();
    }

    @GetMapping("/destinations")
    public List<String> listDestination() {
        return routeService.getDestinationList();
    }

    @PostMapping
    public Route createRoute(@RequestBody Map<String, String> routeInfo) {
        return routeService.createRoute(routeInfo.get("source"), routeInfo.get("destination"), Double.parseDouble(routeInfo.get("distance")));
    }
}
