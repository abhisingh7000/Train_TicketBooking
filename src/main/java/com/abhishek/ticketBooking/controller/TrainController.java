package com.abhishek.ticketBooking.controller;

import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public Train addTrain(@RequestBody Map<String, String> trainInfo) {
        return trainService.createTrain(trainInfo.get("name"), trainInfo.get("owner"), Integer.parseInt(trainInfo.get("noOfSeats")), trainInfo.get("license"));
    }

    @GetMapping
    public Train getTrain(@RequestParam("id") int id) {
        return trainService.findTrain(id);
    }

}
