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

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository,
                               AirCompanyService airCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
    }

    @Override
    public Airplane moveToCompany(Long id, Long companyId) {
        Airplane airplane = getById(id);
        AirCompany airCompany = airCompanyService.get(companyId);
        airplane.setAirCompany(airCompany);
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane getById(Long id) {
        return airplaneRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("No such airplane found by id: "
                        + id));
    }

    @Override
    public Airplane get(Long id) {
        return airplaneRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("No such airplane found by id: "
                        + id));
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }
}
