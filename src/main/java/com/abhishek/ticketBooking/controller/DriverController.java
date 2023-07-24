package com.abhishek.ticketBooking.controller;

import com.abhishek.ticketBooking.entity.Driver;
import com.abhishek.ticketBooking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping
    public Driver findDriver(@PathVariable int driverId) {
        return service.getDriver(driverId);
    }

    @PostMapping
    public Driver addDriver(@RequestBody Map<String, String> driverInfo) {
        return service.addDriver(
                driverInfo.get("name"),
                driverInfo.get("license"),
                driverInfo.get("DOB"),
                driverInfo.get("address"),
                driverInfo.get("DOJ"),
                Integer.parseInt(driverInfo.get("trainId")));
    }

    @PutMapping
    public String changeDriver(@RequestBody Map<String, Integer> details) {
        return service.changeTrain(details.get("driverId"), details.get("trainId"));
    }
}
