package com.task.airservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.airservice.util.DateTimePatternUtil;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "flight_status")
    private FlightStatus flightStatus;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    private int distance;
    @Column(name = "estimated_flight_time")
    private int estimatedFlightTime;
    @JsonFormat(pattern = DateTimePatternUtil.DATE_TIME_PATTERN)
    @Column(name = "started_at")
    private LocalDateTime startedAt;
    @JsonFormat(pattern = DateTimePatternUtil.DATE_TIME_PATTERN)
    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    @JsonFormat(pattern = DateTimePatternUtil.DATE_TIME_PATTERN)
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;
    @JsonFormat(pattern = DateTimePatternUtil.DATE_TIME_PATTERN)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum FlightStatus {
        ACTIVE,
        COMPLETED,
        DELAYED,
        PENDING
    }
}
