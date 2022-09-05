package com.task.airservice.service.mapper.impl;

import com.task.airservice.model.AirCompany;
import com.task.airservice.model.dto.request.AirCompanyRequestDto;
import com.task.airservice.model.dto.response.AirCompanyResponseDto;
import com.task.airservice.service.mapper.RequestDtoMapper;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyMapper implements RequestDtoMapper<AirCompanyRequestDto, AirCompany>,
        ResponseDtoMapper<AirCompanyResponseDto, AirCompany> {
    @Override
    public AirCompany mapToModel(AirCompanyRequestDto dto) {
        AirCompany airCompany = new AirCompany();
        airCompany.setName(dto.getName());
        airCompany.setCompanyType(dto.getCompanyType());
        airCompany.setFoundedAt(dto.getFoundedAt());
        return airCompany;
    }

    @Override
    public AirCompanyResponseDto mapToDto(AirCompany airCompany) {
        AirCompanyResponseDto dto = new AirCompanyResponseDto();
        dto.setId(airCompany.getId());
        dto.setName(airCompany.getName());
        dto.setCompanyType(airCompany.getCompanyType());
        dto.setFoundedAt(airCompany.getFoundedAt());
        return dto;
    }
}
