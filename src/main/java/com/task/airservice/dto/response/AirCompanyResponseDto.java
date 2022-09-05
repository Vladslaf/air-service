package com.task.airservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
