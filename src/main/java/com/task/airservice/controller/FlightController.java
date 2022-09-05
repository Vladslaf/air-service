package com.task.airservice.controller;

import com.task.airservice.dto.response.AirplaneResponseDto;
import com.task.airservice.model.AirCompany;
import com.task.airservice.model.Airplane;
import com.task.airservice.service.AirCompanyService;
import com.task.airservice.service.AirplaneService;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/air-company")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirCompanyService airCompanyService;
    private final ResponseDtoMapper<AirplaneResponseDto, Airplane> responseDtoMapper;

    public AirplaneController(AirplaneService airplaneService,
                              AirCompanyService airCompanyService,
                              ResponseDtoMapper<AirplaneResponseDto,
                                      Airplane> responseDtoMapper) {
        this.airplaneService = airplaneService;
        this.airCompanyService = airCompanyService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PutMapping("/{serialNum}")
    AirplaneResponseDto moveToCompany(@PathVariable String serialNum,
                                      @RequestParam Long companyId) {
        return responseDtoMapper.mapToDto(airplaneService.moveToCompany(serialNum, companyId));
    }


}
