package com.abhishek.ticketBooking.controller;

import com.abhishek.ticketBooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService bookingService;

    @PostMapping
    public Object book(@RequestBody Map<String, Integer> bookingInfo) throws Exception {
        return bookingService.makeBooking(bookingInfo.get("user"), bookingInfo.get("schedule"), bookingInfo.get("seat"));
    }
}
