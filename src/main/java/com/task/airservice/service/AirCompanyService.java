package com.task.airservice.service;

import com.task.airservice.model.AirCompany;

public interface AirCompanyService {
    AirCompany add(AirCompany company);

    AirCompany update(AirCompany company);

    void delete(Long id);

    AirCompany get(Long id);
}
