package com.abhishek.ticketBooking.service;


import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.entity.Driver;
import com.abhishek.ticketBooking.repository.TrainRepository;
import com.abhishek.ticketBooking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TrainRepository trainRepository;

    public Driver getDriver(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    public Driver getDriverByTrain(int trainId) {
        Train train = trainRepository.getReferenceById(trainId);
        return driverRepository.findByTrain(train);
    }

    public Driver addDriver(String name, String license, String dateOfBirth, String address, String dateOfJoining, int trainId) {
        Train train = trainRepository.getReferenceById(trainId);
        Driver driver = new Driver();
        driver.setTrain(train);
        driver.setDriversLicense(license);
        driver.setName(name);
        driver.setAddress(address);
        driver.setDOB(LocalDate.parse(dateOfBirth));
        driver.setDOJ(LocalDate.parse(dateOfJoining));
        driverRepository.save(driver);
        return driver;
    }

    public String changeTrain(int driverId, int trainId) {
        Driver driver = driverRepository.findById(driverId).orElse(null);
        if (driver != null) {
            driver.setTrain(trainRepository.findById(trainId).orElse(null));
            return "Driver set";
        }
        return "Driver not found";
    }
}
