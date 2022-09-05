package com.task.airservice.controller;

import com.task.airservice.dto.request.FlightRequestDto;
import com.task.airservice.dto.response.FlightResponseDto;
import com.task.airservice.model.Flight;
import com.task.airservice.service.FlightService;
import com.task.airservice.service.mapper.RequestDtoMapper;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    private final ResponseDtoMapper<FlightResponseDto, Flight> responseDtoMapper;
    private final RequestDtoMapper<FlightRequestDto, Flight> requestDtoMapper;

    public FlightController(FlightService flightService,
                            ResponseDtoMapper<FlightResponseDto, Flight> responseDtoMapper,
                            RequestDtoMapper<FlightRequestDto, Flight> requestDtoMapper) {
        this.flightService = flightService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @GetMapping("/air-companies/by-status")
    List<FlightResponseDto> findAllAirCompaniesFlightsByStatus(@RequestParam String companyName,
            @RequestParam Flight.FlightStatus status) {
        return flightService.findAllAirCompaniesFlightsByStatus(companyName, status).stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/active/started-more-than-day-ago")
    List<FlightResponseDto> findAllActiveFlightsStartedMoreThanDayAgo() {
        return flightService.findAllActiveFlightsStartedMoreThanDayAgo().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    FlightResponseDto add(@RequestBody FlightRequestDto requestDto) {
        Flight flight = flightService.saveWithPending(requestDtoMapper.mapToModel(requestDto));
        return responseDtoMapper.mapToDto(flight);
    }

    @PutMapping("/change/{id}")
    FlightResponseDto changeStatus(@PathVariable Long id,
                                   @RequestParam Flight.FlightStatus statusToChange) {
        return responseDtoMapper.mapToDto(flightService.changeStatus(id, statusToChange));
    }

    @GetMapping("/completed/duration-more-than-estimated")
    List<FlightResponseDto> findAllCompletedAndDurationMoreThanEstimated() {
        return flightService.findAllCompletedAndDurationMoreThanEstimated().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
