package com.abhishek.ticketBooking.service;

import com.abhishek.ticketBooking.entity.Train;
import com.abhishek.ticketBooking.repository.TrainRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {TrainServiceTest.class})
class TrainServiceTest {

    @Mock
    TrainRepository busRepository;

    @InjectMocks
    TrainService busService;

    @Test
    void findBus() {
        Train bus=new Train();
        bus.setName("ABC");
        bus.setOwner("XYZ Travels");
        bus.setNoOfSeats(50);
        bus.setLicensePlate("GJ04GDJ8829");
        bus.setId(1);

        int id=1;

        when(busRepository.getReferenceById(id)).thenReturn(bus);
        assertEquals(bus,busService.findBus(id));
    }

    @Test
    void createBus() {
    }
}