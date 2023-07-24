package com.abhishek.ticketBooking.service;

import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.entity.Seat;
import com.abhishek.ticketBooking.repository.TrainRepository;
import com.abhishek.ticketBooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TrainRepository trainRepository;

    public List<Seat> listSeatsByTrain(int trainId) {
        Train train = trainRepository.findById(trainId).orElse(null);
        return seatRepository.findByTrain(train);
    }
}
