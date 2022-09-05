package com.task.airservice.model;

import java.time.LocalDate;
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
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "factory_serial_number")
    private String factorySerialNumber;
    private String name;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    @Column(name = "number_of_flights")
    private int numberOfFlights;
    @Column(name = "flight_distance")
    private int flightDistance;
    @Column(name = "fuel_capacity")
    private int fuelCapacity;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private Type type;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public enum Type {
        AIRBUS,
        COMMUTER,
        REGIONAL,
        JET,
        CONCORDE,
        SHORT_HAUL,
        FEDERAL_AIRCRAFT,
        TURBOPROP_AIRCRAFT
    }
}
