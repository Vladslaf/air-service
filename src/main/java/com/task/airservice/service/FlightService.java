package com.task.airservice.service;

import com.task.airservice.model.Flight;
import java.util.List;

public interface FlightService {
    List<Flight> findAllAirCompaniesFlightsByStatus(String companyName, Flight.FlightStatus status);

    List<Flight> findAllActiveFlightsStartedMoreThanDayAgo();

    Flight saveWithPending(Flight flight);

    Flight changeStatus(Long id, Flight.FlightStatus statusToChange);

    Flight findById(Long id);

    List<Flight> findAllCompletedAndDurationMoreThanEstimated();
}
