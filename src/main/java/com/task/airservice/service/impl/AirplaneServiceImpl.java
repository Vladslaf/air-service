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
    public AirCompany add(AirCompany author) {
        return airCompanyRepository.save(author);
    }

    @Override
    public AirCompany update(AirCompany author) {
        return airCompanyRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        airCompanyRepository.deleteById(id);
    }

    @Override
    public AirCompany get(Long id) {
        return airCompanyRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Can not get AirCompany by id: " + id));
    }
}
