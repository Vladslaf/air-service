package com.task.airservice.repository;

import com.task.airservice.model.AirCompany;
import com.task.airservice.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, String> {
}
