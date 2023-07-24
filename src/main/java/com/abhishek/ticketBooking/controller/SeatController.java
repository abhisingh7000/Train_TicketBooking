package com.abhishek.ticketBooking.controller;


import com.abhishek.ticketBooking.entity.Seat;
import com.abhishek.ticketBooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class    SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> listSeats(@RequestParam("trainId") int trainId) {
        return seatService.listSeatsByTrain(trainId);
    }
}
