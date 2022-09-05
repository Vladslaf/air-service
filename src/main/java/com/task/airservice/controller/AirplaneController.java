package com.task.airservice.controller;

import com.task.airservice.dto.request.AirplaneRequestDto;
import com.task.airservice.dto.response.AirplaneResponseDto;
import com.task.airservice.model.Airplane;
import com.task.airservice.service.AirplaneService;
import com.task.airservice.service.mapper.RequestDtoMapper;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final ResponseDtoMapper<AirplaneResponseDto, Airplane> airplaneResponseDtoMapper;
    private final RequestDtoMapper<AirplaneRequestDto, Airplane> airplaneRequestDtoMapper;

    public AirplaneController(AirplaneService airplaneService,
                              ResponseDtoMapper<AirplaneResponseDto,
                                      Airplane> airplaneResponseDtoMapper,
                              RequestDtoMapper<AirplaneRequestDto,
                                      Airplane> airplaneRequestDtoMapper) {
        this.airplaneService = airplaneService;
        this.airplaneResponseDtoMapper = airplaneResponseDtoMapper;
        this.airplaneRequestDtoMapper = airplaneRequestDtoMapper;
    }

    @PutMapping("/{id}")
    AirplaneResponseDto moveToCompany(@PathVariable Long id,
                                      @RequestParam Long companyId) {
        return airplaneResponseDtoMapper.mapToDto(airplaneService.moveToCompany(id, companyId));
    }

    @PostMapping()
    AirplaneResponseDto add(@RequestBody AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneService.save(airplaneRequestDtoMapper.mapToModel(requestDto));
        return airplaneResponseDtoMapper.mapToDto(airplane);
    }
}
