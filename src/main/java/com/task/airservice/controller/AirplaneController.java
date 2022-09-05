package com.task.airservice.controller;

import com.task.airservice.model.AirCompany;
import com.task.airservice.model.dto.request.AirCompanyRequestDto;
import com.task.airservice.model.dto.response.AirCompanyResponseDto;
import com.task.airservice.service.AirCompanyService;
import com.task.airservice.service.mapper.RequestDtoMapper;
import com.task.airservice.service.mapper.ResponseDtoMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/air-company")
public class AirCompanyController {

    private final AirCompanyService airCompanyService;
    private final RequestDtoMapper<AirCompanyRequestDto, AirCompany> airCompanyRequestDtoMapper;
    private final ResponseDtoMapper<AirCompanyResponseDto, AirCompany> airCompanyResponseDtoMapper;

    public AirCompanyController(AirCompanyService airCompanyService,
                                RequestDtoMapper<AirCompanyRequestDto, AirCompany> airCompanyRequestDtoMapper,
                                ResponseDtoMapper<AirCompanyResponseDto, AirCompany> airCompanyResponseDtoMapper) {
        this.airCompanyService = airCompanyService;
        this.airCompanyRequestDtoMapper = airCompanyRequestDtoMapper;
        this.airCompanyResponseDtoMapper = airCompanyResponseDtoMapper;
    }

    @GetMapping ("/{id}")
    @ApiOperation(value = "update author by id")
    public AirCompanyResponseDto update(@PathVariable Long id) {
        AirCompany company = airCompanyService.get(id);
        return airCompanyResponseDtoMapper.mapToDto(company);
    }

    @PostMapping
    @ApiOperation(value = "add new company")
    @ResponseStatus(HttpStatus.CREATED)
    public AirCompanyResponseDto add(@RequestBody AirCompanyRequestDto airCompanyRequestDto) {
        AirCompany company = airCompanyService.add(airCompanyRequestDtoMapper.mapToModel(airCompanyRequestDto));
        return airCompanyResponseDtoMapper.mapToDto(company);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update company by id")
    public AirCompanyResponseDto update(@PathVariable Long id,
                                    @RequestBody AirCompanyRequestDto airCompanyRequestDto) {
        AirCompany company = airCompanyRequestDtoMapper.mapToModel(airCompanyRequestDto);
        company.setId(id);
        return airCompanyResponseDtoMapper.mapToDto(airCompanyService.update(company));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete company by id")
    public void delete(@PathVariable Long id) {
        airCompanyService.delete(id);
    }
}
