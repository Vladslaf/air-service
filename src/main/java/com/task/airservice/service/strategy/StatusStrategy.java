package com.task.airservice.service.strategy;

import com.task.airservice.model.Flight;

public interface StatusStrategy {
    public void changeStatus(Flight flight);
}
