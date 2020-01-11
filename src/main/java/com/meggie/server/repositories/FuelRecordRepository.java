package com.meggie.server.repositories;

import com.meggie.server.models.FuelRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRecordRepository extends JpaRepository<FuelRecord, Long> {
}