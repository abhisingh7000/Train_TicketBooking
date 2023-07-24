package com.abhishek.ticketBooking.repository;

import com.abhishek.ticketBooking.entity.Ticket;
import com.abhishek.ticketBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> getBookingsByUser(User user);
}
