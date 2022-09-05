package com.task.airservice.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightRequestDto {
    private Long airplaneId;
    private Long airCompanyId;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
}
