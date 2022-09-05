package com.task.airservice.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "company_type")
    private Type companyType;
    @Column(name = "founded_at")
    private LocalDate foundedAt;

    public enum Type {
        LIMITED_LIABILITY,
        BUSINESS,
        FOREIGN,
        GOVERNMENT,
        HOLDING,
        SUBSIDIARY,
        ASSOCIATE,
        LISTED,
        UNLISTED,
        DORMANT,
        NIDHI
    }
}
