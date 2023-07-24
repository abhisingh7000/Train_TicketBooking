package com.abhishek.ticketBooking.service;


import com.abhishek.ticketBooking.entity.*;
import com.abhishek.ticketBooking.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository bookingRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Ticket> getBookingById(int booking_id) {
        return bookingRepository.findById(booking_id);
    }

    public List<Ticket> getBookingByUser(User user) {
        return bookingRepository.getBookingsByUser(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public Object makeBooking(int userId, int scheduleId, int seatId) throws Exception {
        Schedule schedule = scheduleRepository.getReferenceById(scheduleId);
        Seat seat = seatRepository.getReferenceById(seatId);
        User user = userRepository.getReferenceById(userId);
        if (seat.isBooked()){
            return "The seat is already booked!!!";
        }
        if (schedule.getTrain().getNoOfSeats() == 0) {
            return "All seats booked";
        }
        Train train = schedule.getTrain();
        entityManager.lock(seat, LockModeType.PESSIMISTIC_WRITE);
        entityManager.lock(train, LockModeType.PESSIMISTIC_WRITE);
        Ticket booking = new Ticket();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        booking.setBookingTime(timestamp);
        booking.setSchedule(schedule);
        booking.setUser(user);
        booking.setSeat(seat);
        bookingRepository.save(booking);
        seat.setBooked(true);
        seatRepository.save(seat);
        train.setNoOfSeats(train.getNoOfSeats() - 1);
        trainRepository.save(train);
        return booking;
    }
}
