package com.task.airservice.dto.response;

import com.task.airservice.model.Airplane;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirplaneResponseDto {
    private Long id;
    private String factorySerialNumber;
    private String name;
    private Long airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private Airplane.Type type;
    private LocalDate createdAt;
}
