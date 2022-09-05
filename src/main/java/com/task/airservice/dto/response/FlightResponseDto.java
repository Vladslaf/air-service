package com.task.airservice.dto.response;

import com.task.airservice.model.Flight;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightResponseDto {
    private Long id;
    private Flight.FlightStatus flightStatus;
    private Long airplaneId;
    private Long airCompanyId;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
}
