package com.task.airservice.service.impl;

import com.task.airservice.exception.DataProcessingException;
import com.task.airservice.model.AirCompany;
import com.task.airservice.model.Airplane;
import com.task.airservice.repository.AirplaneRepository;
import com.task.airservice.service.AirCompanyService;
import com.task.airservice.service.AirplaneService;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyService airCompanyService;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository, AirCompanyService airCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
    }

    @Override
    public Airplane moveToCompany(String serialNum, Long companyId) {
        Airplane airplane = getBySerialNum(serialNum);
        AirCompany airCompany = airCompanyService.get(companyId);
        airplane.setAirCompany(airCompany);
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane getBySerialNum(String serialNum) {
        return airplaneRepository.findById(serialNum).orElseThrow(
                () -> new DataProcessingException("No airplane found with such serial number: "
                        + serialNum));
    }
}
