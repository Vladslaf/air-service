package com.task.airservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanyRequestDto {
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
