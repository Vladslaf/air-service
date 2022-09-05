package com.task.airservice.dto.request;

import com.task.airservice.model.AirCompany;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanyRequestDto {
    private String name;
    private AirCompany.Type companyType;
    private LocalDate foundedAt;
}
