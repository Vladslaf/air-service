package com.task.airservice.repository;

import com.task.airservice.model.Flight;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value =
            "SELECT f "
                    + "FROM Flight AS f "
                    + "JOIN f.airplane AS a "
                    + "WHERE a.airCompany.name = :name AND f.flightStatus = :status")
    List<Flight> findAllAirCompaniesFlightsByStatus(@Param("name") String companyName,
                                                    @Param("status") Flight.FlightStatus status);

    @Query(value =
            "SELECT f "
                    + "FROM Flight AS f "
                    + "WHERE f.flightStatus = 'ACTIVE' AND :time > f.startedAt")
    List<Flight> findAllActiveFlightsAndStartedBefore(@Param("time") LocalDateTime time);

    @Query(value =
            "SELECT * "
                    + "FROM flights AS f "
                    + "WHERE f.flight_status = 'COMPLETED' "
                        + "AND f.estimated_flight_time "
                        + "< TIMESTAMPDIFF(MINUTE, f.started_at, f.ended_at)",
            nativeQuery = true)
    List<Flight> findAllCompletedAndDurationMoreThanEstimated();
}
