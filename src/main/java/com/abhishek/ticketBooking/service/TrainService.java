package com.abhishek.ticketBooking.service;


import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.entity.Seat;
import com.abhishek.ticketBooking.repository.TrainRepository;
import com.abhishek.ticketBooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private SeatRepository seatRepository;

    public Train findTrain(int trainId) {
        return trainRepository.getReferenceById(trainId);
    }

    public Train createTrain(String name, String owner, int noOfSeats, String license) {
        List<Seat> seats = new ArrayList<>();
        Train train = new Train();
        train.setNoOfSeats(noOfSeats);
        train.setName(name);
        train.setOwner(owner);
        train.setLicensePlate(license);
        trainRepository.save(train);
        for (int j = 0; j < noOfSeats; j++) {
            Seat seat = new Seat();
            seat.setBooked(false);
            seat.setTrain(train);
            seat.setSeatMeta(j % 2 == 0 ? "aisle" : "window");
            seats.add(seat);
        }
        seatRepository.saveAllAndFlush(seats);
        return train;
    }
}
