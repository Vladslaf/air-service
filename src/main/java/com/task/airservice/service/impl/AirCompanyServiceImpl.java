package com.task.airservice.service.impl;

import com.task.airservice.exception.DataProcessingException;
import com.task.airservice.model.AirCompany;
import com.task.airservice.repository.AirCompanyRepository;
import com.task.airservice.service.AirCompanyService;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository airCompanyRepository;

    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public AirCompany add(AirCompany company) {
        return airCompanyRepository.save(company);
    }

    @Override
    public AirCompany update(AirCompany company) {
        return airCompanyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
        airCompanyRepository.deleteById(id);
    }

    @Override
    public AirCompany get(Long id) {
        return airCompanyRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("No such AirCompany found by id: " + id));
    }
}
