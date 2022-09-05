package com.task.airservice.dto.response;

import com.task.airservice.model.AirCompany;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private AirCompany.Type companyType;
    private LocalDate foundedAt;
}
