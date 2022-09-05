package com.task.airservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneRequestDto {
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
