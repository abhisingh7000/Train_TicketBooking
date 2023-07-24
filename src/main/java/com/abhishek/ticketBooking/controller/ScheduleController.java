package com.abhishek.ticketBooking.controller;


import com.abhishek.ticketBooking.entity.Schedule;
import com.abhishek.ticketBooking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public Schedule createSchedule(@RequestBody Map<String, String> scheduleInfo) {
        return scheduleService.createSchedule(
                Integer.parseInt(scheduleInfo.get("routeId")),
                Integer.parseInt(scheduleInfo.get("trainId")),
                LocalTime.parse(scheduleInfo.get("start")),
                LocalTime.parse(scheduleInfo.get("end")),
                LocalDate.parse(scheduleInfo.get("date"))
        );
    }

    @GetMapping
    public List<Schedule> listSchedules(@RequestParam("source") String source, @RequestParam("destination") String destination, @RequestParam("time") String time, @RequestParam("date") String date) {
        return scheduleService.getSchedulesByRoute(source, destination, LocalDate.parse(date));
    }
}
