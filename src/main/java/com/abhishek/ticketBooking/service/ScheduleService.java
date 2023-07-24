package com.abhishek.ticketBooking.service;


import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.entity.Route;
import com.abhishek.ticketBooking.entity.Schedule;
import com.abhishek.ticketBooking.repository.TrainRepository;
import com.abhishek.ticketBooking.repository.RouteRepository;
import com.abhishek.ticketBooking.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private TrainRepository trainRepository;

    public List<Schedule> getSchedulesByRoute(String source, String destination, LocalDate date) {
        List<Route> routes = routeRepository.findBySourceAndDestination(source, destination);
        List<Schedule> schedules = new ArrayList<>();
        routes.forEach((e) -> {
            schedules.addAll(scheduleRepository.findByRouteAndTravelDate(e, date));
        });
        return schedules;
    }

    public Schedule createSchedule(int routeId, int trainId, LocalTime start, LocalTime end, LocalDate date) {
        Train train = trainRepository.getReferenceById(trainId);
        Route route = routeRepository.getReferenceById(routeId);
        Schedule schedule = new Schedule();
        schedule.setTrain(train);
        schedule.setRoute(route);
        schedule.setStartTime(start);
        schedule.setEndTime(end);
        schedule.setTravelDate(date);
        scheduleRepository.save(schedule);
        return schedule;
    }
}
