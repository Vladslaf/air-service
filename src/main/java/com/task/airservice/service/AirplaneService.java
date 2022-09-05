package com.task.airservice.service;

import com.task.airservice.model.Airplane;

public interface AirplaneService {
    Airplane moveToCompany(Long id, Long companyId);

    Airplane getById(Long id);

    Airplane get(Long id);

    Airplane save(Airplane airplane);
}
