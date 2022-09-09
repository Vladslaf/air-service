package com.task.airservice.service.impl;

import com.task.airservice.exception.AlreadyWithThatStatusException;
import com.task.airservice.exception.DataProcessingException;
import com.task.airservice.model.Flight;
import com.task.airservice.repository.FlightRepository;
import com.task.airservice.service.FlightService;
import com.task.airservice.service.strategy.ActiveStatusStrategy;
import com.task.airservice.service.strategy.CompletedStatusStrategy;
import com.task.airservice.service.strategy.DelayedStatusStrategy;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final ActiveStatusStrategy activeStatusStrategy;
    private final CompletedStatusStrategy completedStatusStrategy;
    private final DelayedStatusStrategy delayedStatusStrategy;

    public FlightServiceImpl(FlightRepository flightRepository,
                             ActiveStatusStrategy activeStatusStrategy,
                             CompletedStatusStrategy completedStatusStrategy,
                             DelayedStatusStrategy delayedStatusStrategy) {
        this.flightRepository = flightRepository;
        this.activeStatusStrategy = activeStatusStrategy;
        this.completedStatusStrategy = completedStatusStrategy;
        this.delayedStatusStrategy = delayedStatusStrategy;
    }

    @Override
    public List<Flight> findAllAirCompaniesFlightsByStatus(String companyName,
                                                           Flight.FlightStatus status) {
        return flightRepository.findAllAirCompaniesFlightsByStatus(companyName, status);
    }

    @Override
    public List<Flight> findAllActiveFlightsStartedMoreThanDayAgo() {
        LocalDateTime time = LocalDateTime.now().minusHours(24);
        return flightRepository.findAllActiveFlightsAndStartedBefore(time);
    }

    @Override
    public Flight saveWithPending(Flight flight) {
        flight.setFlightStatus(Flight.FlightStatus.PENDING);
        flight.setCreatedAt(LocalDateTime.now());
        return flightRepository.save(flight);
    }

    @Override
    public Flight changeStatus(Long id, Flight.FlightStatus statusToChange) {
        Flight flight = findById(id);
        if (flight.getFlightStatus().equals(statusToChange)) {
            throw new AlreadyWithThatStatusException("Flight already has set status to: "
                    + statusToChange);
        }
        switch (statusToChange) {
            case DELAYED:
                delayedStatusStrategy.changeStatus(flight);
                break;
            case ACTIVE:
                activeStatusStrategy.changeStatus(flight);
                break;
            case COMPLETED:
                completedStatusStrategy.changeStatus(flight);
                break;
            default:
                break;
        }
        return flightRepository.save(flight);
    }

    @Override
    public Flight findById(Long id) {
        return flightRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("No such flight found by id: "
                        + id));
    }

    @Override
    public List<Flight> findAllCompletedAndDurationMoreThanEstimated() {
        return flightRepository.findAllCompletedAndDurationMoreThanEstimated();
    }
}
