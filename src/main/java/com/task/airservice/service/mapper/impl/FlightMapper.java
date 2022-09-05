package com.task.airservice.service.mapper.impl;

import com.task.airservice.dto.request.AirplaneRequestDto;
import com.task.airservice.dto.response.AirplaneResponseDto;
import com.task.airservice.model.Airplane;
import com.task.airservice.service.AirCompanyService;
import com.task.airservice.service.mapper.RequestDtoMapper;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class AirplaneMapper implements ResponseDtoMapper<AirplaneResponseDto, Airplane>,
        RequestDtoMapper<AirplaneRequestDto, Airplane> {
    private final AirCompanyService airCompanyService;

    public AirplaneMapper(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @Override
    public AirplaneResponseDto mapToDto(Airplane airplane) {
        AirplaneResponseDto dto = new AirplaneResponseDto();
        dto.setId(airplane.getId());
        dto.setName(airplane.getName());
        dto.setFactorySerialNumber(airplane.getFactorySerialNumber());
        dto.setAirCompanyId(airplane.getAirCompany().getId());
        dto.setNumberOfFlights(airplane.getNumberOfFlights());
        dto.setFlightDistance(airplane.getFlightDistance());
        dto.setFuelCapacity(airplane.getFuelCapacity());
        dto.setType(airplane.getType());
        dto.setCreatedAt(airplane.getCreatedAt());
        return dto;
    }

    @Override
    public Airplane mapToModel(AirplaneRequestDto dto) {
        Airplane airplane = new Airplane();
        airplane.setAirCompany(airCompanyService.get(dto.getAirCompanyId()));
        airplane.setFactorySerialNumber(dto.getFactorySerialNumber());
        airplane.setName(dto.getName());
        airplane.setCreatedAt(dto.getCreatedAt());
        airplane.setFlightDistance(dto.getFlightDistance());
        airplane.setFuelCapacity(dto.getFuelCapacity());
        airplane.setType(dto.getType());
        airplane.setNumberOfFlights(dto.getNumberOfFlights());
        return airplane;
    }
}
