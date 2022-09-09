package com.task.airservice.service.strategy;

import com.task.airservice.model.Flight;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class DelayedStatusStrategy implements StatusStrategy {
    @Override
    public void changeStatus(Flight flight) {
        flight.setFlightStatus(Flight.FlightStatus.DELAYED);
        flight.setDelayStartedAt(LocalDateTime.now());
    }
}
