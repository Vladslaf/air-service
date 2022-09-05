package com.task.airservice.service.mapper.impl;

import com.task.airservice.dto.request.FlightRequestDto;
import com.task.airservice.dto.response.FlightResponseDto;
import com.task.airservice.model.Airplane;
import com.task.airservice.model.Flight;
import com.task.airservice.service.AirplaneService;
import com.task.airservice.service.mapper.RequestDtoMapper;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class FlightMapper implements ResponseDtoMapper<FlightResponseDto, Flight>,
        RequestDtoMapper<FlightRequestDto, Flight> {
    private final AirplaneService airplaneService;

    public FlightMapper(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @Override
    public Flight mapToModel(FlightRequestDto dto) {
        Flight flight = new Flight();
        Airplane airplane = airplaneService.get(dto.getAirplaneId());
        flight.setAirplane(airplane);
        flight.setAirCompany(airplane.getAirCompany());
        flight.setDepartureCountry(dto.getDepartureCountry());
        flight.setDestinationCountry(dto.getDestinationCountry());
        flight.setDistance(dto.getDistance());
        flight.setEstimatedFlightTime(dto.getEstimatedFlightTime());
        return flight;
    }

    @Override
    public FlightResponseDto mapToDto(Flight flight) {
        FlightResponseDto dto = new FlightResponseDto();
        dto.setId(flight.getId());
        dto.setFlightStatus(flight.getFlightStatus());
        dto.setAirplaneId(flight.getAirplane().getId());
        dto.setAirCompanyId(flight.getAirCompany().getId());
        dto.setDepartureCountry(flight.getDepartureCountry());
        dto.setDestinationCountry(flight.getDestinationCountry());
        dto.setDistance(flight.getDistance());
        dto.setEstimatedFlightTime(flight.getEstimatedFlightTime());
        dto.setStartedAt(flight.getStartedAt());
        dto.setEndedAt(flight.getEndedAt());
        dto.setDelayStartedAt(flight.getDelayStartedAt());
        dto.setCreatedAt(flight.getCreatedAt());
        return dto;
    }
}
